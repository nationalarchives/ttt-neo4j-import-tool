package uk.gov.nationalarchives.ttt.neo4j.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.nationalarchives.ttt.neo4j.config.TTTNeo4jConfiguration;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.PersonDocumentRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl.PersonGraphRepositoryImpl;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;
import uk.gov.nationalarchives.ttt.neo4j.service.PersonGraphService;
import uk.gov.nationalarchives.ttt.neo4j.service.async.BulkSavePeopleTask;
import uk.gov.nationalarchives.ttt.neo4j.service.async.PersonCentralisedBrowser;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jcharlet on 11/23/15.
 */
@Service
public class PersonGraphServiceImpl implements PersonGraphService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PersonGraphRepository personGraphRepository;
    private final PersonDocumentRepository personDocumentRepository;


    private final SessionFactory sessionFactory;

    @Autowired
    public PersonGraphServiceImpl(PersonGraphRepository personGraphRepository, PersonDocumentRepository personDocumentRepository, SessionFactory sessionFactory) {
        this.personGraphRepository = personGraphRepository;
        this.personDocumentRepository = personDocumentRepository;
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void savePersonGraph(Person person) {
        Integer personOutputId = personGraphRepository.createPerson(person);


        if (!CollectionUtils.isEmpty(person.getHasFamilyNames())) {
            for (HasFamilyName hasFamilyName : person.getHasFamilyNames()) {
                final Integer familyNameOutputId = personGraphRepository.mergeFamilyName(hasFamilyName.getFamilyName());

                personGraphRepository.createRelationshipBetweenPersonAndFamilyName(personOutputId, hasFamilyName, familyNameOutputId);
            }
        }

        if (!CollectionUtils.isEmpty(person.getHasForeNames())) {
            for (HasForeName hasForeName : person.getHasForeNames()) {
                final Integer foreNameOutputId = personGraphRepository.mergeForeName(hasForeName.getForeName());

                personGraphRepository.createRelationshipBetweenPersonAndForeName(personOutputId, hasForeName, foreNameOutputId);
            }
        }


        if (!CollectionUtils.isEmpty(person.getHasReferences())) {
            for (HasReference hasReference : person.getHasReferences()) {
                final Integer referenceOutputId = personGraphRepository.mergeReference(hasReference.getReference());

                personGraphRepository.createRelationship(personOutputId, new HashMap<String, Object>(), referenceOutputId,
                        "HAS_REFERENCE");
            }
        }

        if (!CollectionUtils.isEmpty(person.getHasEvents())) {
            for (HasEvent hasEvent : person.getHasEvents()) {
                if (hasEvent.getEvent().getHasYear() == null && hasEvent.getEvent().getHasMonth()==null && hasEvent
                        .getEvent().getHasDay()==null) {
                    continue;
                }

                final Integer eventOutputId = personGraphRepository.createEvent(hasEvent.getEvent());

                personGraphRepository.createRelationship(personOutputId, new HashMap<String, Object>(), eventOutputId,
                        "HAS_EVENT");

                Year year = null;
                if (hasEvent.getEvent().getHasYear() != null) {
                    year = hasEvent.getEvent().getHasYear().getYear();
                }
                Month month = null;
                if (hasEvent.getEvent().getHasMonth() != null) {
                    month = hasEvent.getEvent().getHasMonth().getMonth();
                }
                Day day = null;
                if (hasEvent.getEvent().getHasDay() != null) {
                    day = hasEvent.getEvent().getHasDay().getDay();
                }

                final Integer dateOutputId = personGraphRepository.mergeDateNodesAndTheirSubRelationships(year, month, day);

                personGraphRepository.createEventToDateRelationship(eventOutputId, new HashMap<String, Object>(), dateOutputId, year, month, day);
            }

        }

        if (person.getInContainer() != null) {
            InContainer inContainer = person.getInContainer();
            if (inContainer.getDocument() != null) {
                final Integer documentId = personGraphRepository.mergeDocument(inContainer.getDocument());

                personGraphRepository.createRelationship(personOutputId, new HashMap<String, Object>(), documentId,
                        "IN_CONTAINER");
            }
            if (inContainer.getSource() != null) {
                final Integer sourceId = personGraphRepository.mergeSource(inContainer.getSource());

                personGraphRepository.createRelationship(personOutputId, new HashMap<String, Object>(), sourceId,
                        "IN_CONTAINER");
            }
        }
    }


    public static final int NB_THREADS = 4;

    public static int PAGE_SIZE = 50;


    @Override
    public void bulkSavePeopleGraphFromMongoCollection(String personCollectionName, Integer limit) {
        personDocumentRepository.setPersonCollectionName(personCollectionName);

        PersonCentralisedBrowser personCentralisedBrowser = new PersonCentralisedBrowser(limit, PAGE_SIZE, personDocumentRepository);


        ExecutorService executorService = Executors.newFixedThreadPool(NB_THREADS);
        ConcurrentLinkedQueue<Future<?>> tasks = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < NB_THREADS; i++) {
            Session session = sessionFactory.openSession(TTTNeo4jConfiguration.HOST,TTTNeo4jConfiguration.USER,
                    TTTNeo4jConfiguration.PASSWORD);

            tasks.add(executorService.submit(new BulkSavePeopleTask(personCentralisedBrowser, new PersonGraphServiceImpl(new
                    PersonGraphRepositoryImpl(session), personDocumentRepository, sessionFactory))));
        }


        AtomicInteger nbOfTasksDone = new AtomicInteger(0);
        while (nbOfTasksDone.get() < NB_THREADS) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tasks.forEach(task -> {
                if (task.isDone()) {
                    nbOfTasksDone.incrementAndGet();
                    tasks.remove(task);
                }
            });
        }
    }
}
