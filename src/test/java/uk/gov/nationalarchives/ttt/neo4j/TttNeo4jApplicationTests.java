package uk.gov.nationalarchives.ttt.neo4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.PersonDocumentRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.MongoPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Person;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TttNeo4jApplication.class)
@WebAppConfiguration
public class TttNeo4jApplicationTests {

    @Autowired
    PersonGraphRepository personGraphRepository;

    @Autowired
    PersonDocumentRepository personDocumentRepository;

	@Test
	public void testSaveOnePersonFromMongoIntoNeo4j() {
        personGraphRepository.deleteAll();
        final List<MongoPerson> people= personDocumentRepository.findAll();
        Assert.notEmpty(people);
        for (Person person:people){
            Neo4jPerson neo4jPerson = new Neo4jPerson(person);
            personGraphRepository.save(neo4jPerson);
        }
    }


}
