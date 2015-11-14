package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j;

import org.springframework.data.neo4j.repository.GraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.FamilyName;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface FamilyNameRepository extends GraphRepository<FamilyName> {
}
