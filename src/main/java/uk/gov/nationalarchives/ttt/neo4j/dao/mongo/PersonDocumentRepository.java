package uk.gov.nationalarchives.ttt.neo4j.dao.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.Person;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface PersonDocumentRepository
        extends MongoRepository<Person, String>
{
}
