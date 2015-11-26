package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j;


import uk.gov.nationalarchives.ttt.neo4j.domain.Link;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface LinkGraphRepository {

    void mergeRelationshipBetweenPeople(Integer personAId, Link link, Integer personBId);
}
