package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j;


import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.Person;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface PersonGraphRepository {
    void createOrMergePersonGraph(Person person);
}
