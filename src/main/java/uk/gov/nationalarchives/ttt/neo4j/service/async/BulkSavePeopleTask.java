package uk.gov.nationalarchives.ttt.neo4j.service.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.MongoPerson;
import uk.gov.nationalarchives.ttt.neo4j.service.PersonGraphService;

/**
 * Created by jcharlet on 11/23/15.
 */
public class BulkSavePeopleTask implements Runnable {

    Logger logger = LoggerFactory.getLogger(getClass());

    final PersonCentralisedBrowser personCentralisedBrowser;
    final PersonGraphService personGraphService;


    public BulkSavePeopleTask(PersonCentralisedBrowser personCentralisedBrowser, PersonGraphService personGraphService) {
        this.personCentralisedBrowser = personCentralisedBrowser;
        this.personGraphService = personGraphService;
    }


    @Override
    public void run() {
        Page<MongoPerson> personPage;
        do {
            personPage = personCentralisedBrowser.getNextPerson();
            if (personPage!=null) {
                personPage.getContent().forEach(person -> {
                    logger.info("saving person: " + person.getRef());
                    try {
                        personGraphService.savePersonGraph(person);
                        Thread.sleep(50);
                    } catch (Exception e) {
                        logger.error("ERROR", e);
                    }
                });
            }
        }while (personPage!=null);

        logger.info("Thread Task to bulk save people ended");
    }
}