package uk.gov.nationalarchives.ttt.neo4j.service;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;

import java.util.HashMap;

/**
 * Created by jcharlet on 11/23/15.
 */
@Service
public class PersonGraphService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PersonGraphRepository personGraphRepository;

    @Autowired
    public PersonGraphService(PersonGraphRepository personGraphRepository) {
        this.personGraphRepository = personGraphRepository;
    }

    @Transactional
    public void createOrMergePersonGraph(Person person) {
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
                if (hasEvent.getEvent().getHasYear() == null) {
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
}
