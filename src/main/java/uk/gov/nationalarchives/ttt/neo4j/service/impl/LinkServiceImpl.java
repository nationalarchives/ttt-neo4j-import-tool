package uk.gov.nationalarchives.ttt.neo4j.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.LinkRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.LinkGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.Link;
import uk.gov.nationalarchives.ttt.neo4j.service.LinkService;

/**
 * Created by jcharlet on 11/23/15.
 */
@Service
public class LinkServiceImpl implements LinkService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final LinkGraphRepository linkGraphRepository;
    private final PersonGraphRepository personGraphRepository;
    private final LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkGraphRepository linkGraphRepository, PersonGraphRepository personGraphRepository, LinkRepository linkRepository) {
        this.linkGraphRepository = linkGraphRepository;
        this.personGraphRepository = personGraphRepository;
        this.linkRepository = linkRepository;
    }

//    @Override
    @Override
    public void saveLink(Link link, String sourceFile) {
        link.setSourceFile(sourceFile);

        Integer personAId = personGraphRepository.findPersonByRef(link.getRefA());
        Integer personBId = personGraphRepository.findPersonByRef(link.getRefB());

        if (personAId==null || personBId==null){
            logger.error("1 element of the relationship does not exist: personAID:{}, refA:{}, personBId:{}, refB:{}",
                    personAId,
                    link
                            .getRefA(),personBId, link.getRefB());
            return;
        }

        linkGraphRepository.mergeRelationshipBetweenPeople(personAId, link, personBId);
    }

    @Override
    public void bulkSaveLinksIntoGraphFromMongoCollection(String collectionName, Long limit, Double scoreThreshold) {
        logger.info("bulkSaveLinksIntoGraphFromMongoCollection");
        int pageNumber = 0;
        int pageSize = 100;

        linkRepository.setCollectionName(collectionName);

        if (limit==null){
            limit=linkRepository.count();
        }

        Page<Link> pageResults;
        do{
            pageResults = linkRepository.findByScoreGreaterThan(scoreThreshold, new PageRequest(pageNumber, pageSize));
            pageResults.forEach(link -> {
                //FIXME get into logging table 2 source files from linker name
                saveLink(link, collectionName);
            });
            pageNumber++;

        }while (pageResults.hasNext() && pageNumber*pageSize<limit);

        logger.debug("bulkSaveLinksIntoGraphFromMongoCollection ended");

    }

}
