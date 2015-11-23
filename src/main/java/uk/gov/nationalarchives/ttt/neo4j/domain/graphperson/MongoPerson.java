package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson;

import org.springframework.data.mongodb.core.mapping.Document;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.Person;

/**
 * Created by jcharlet on 11/23/15.
 */
@Document(collection = "#{mongoConfiguration.getPersonCollectionName()}")
public class MongoPerson extends Person{
}
