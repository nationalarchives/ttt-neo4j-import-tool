package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j;

import org.springframework.data.neo4j.repository.GraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.neo4j.graphperson.Neo4jPerson;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface PersonGraphRepository extends GraphRepository<Neo4jPerson> {
}
