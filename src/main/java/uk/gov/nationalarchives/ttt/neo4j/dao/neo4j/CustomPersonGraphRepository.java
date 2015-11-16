package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j;

import org.springframework.data.neo4j.repository.GraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Person;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface CustomPersonGraphRepository {
    Neo4jPerson createOrMergePersonGraph(Person person);
}
