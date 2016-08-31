package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.LinkGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.Link;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcharlet on 16/11/15.
 */
@Repository
public class LinkGraphRepositoryImpl extends GenericGraphRepository implements LinkGraphRepository {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public LinkGraphRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public void mergeRelationshipBetweenPeople(Integer personAId, Link link, Integer personBId) {
        Map<String, Object> relationshipProperties = new HashMap<>();
        relationshipProperties.put("score",link.getScore());
        relationshipProperties.put("source",link.getSource());
        mergeBothWaysRelationship(personAId, relationshipProperties, personBId, "LINK");
    }

    @Override
    public void removeLinksFromSource(String linksCollectionName) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("source",linksCollectionName);
        session.query("MATCH  (:Person)-[n:LINK]-(:Person) WHERE n.source={source} DETACH DELETE n", parameters);
    }


}
