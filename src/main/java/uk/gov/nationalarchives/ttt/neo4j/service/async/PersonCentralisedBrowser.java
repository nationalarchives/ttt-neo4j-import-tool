package uk.gov.nationalarchives.ttt.neo4j.service.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.PersonDocumentRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.MongoPerson;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jcharlet on 11/23/15.
 */
public class PersonCentralisedBrowser {

    Logger logger = LoggerFactory.getLogger(getClass());

    final long maxElements;
    final int pageSize;
    private final PersonDocumentRepository personDocumentRepository;

    public static AtomicInteger pageNumber = new AtomicInteger(0);

    public PersonCentralisedBrowser(Integer maxElements, int pageSize, PersonDocumentRepository
            personDocumentRepository) {
        this.personDocumentRepository = personDocumentRepository;
        this.pageSize = pageSize;
        if(maxElements!=null){
            this.maxElements = maxElements;
        }else{
            this.maxElements = personDocumentRepository.count();
        }
    }

    public Page<MongoPerson> getNextPerson() {
        Integer pageNumber =  this.pageNumber.getAndIncrement();
        if(pageNumber*pageSize>=maxElements){
            logger.info("no more documents to browse");
            return null;
        }
        logger.info("page no " + pageNumber + ", did " + (100*pageNumber*pageSize/maxElements) + "% so " +
                "far," +
                " "+
                (maxElements-pageNumber*pageSize)
                +" " +
                "elements" +
                " left");
        PageRequest pageRequest = new PageRequest(pageNumber, pageSize);
        return personDocumentRepository.findAll(pageRequest);
    }
}
