package uk.gov.nationalarchives.ttt.neo4j;

import com.mongodb.BasicDBObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.cypher.internal.compiler.v1_9.commands.Has;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.FamilyNameRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.MongoPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Person;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.FamilyName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasFamilyName;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TttNeo4jApplication.class)
@WebAppConfiguration
public class TttNeo4jApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    Session session;

    private Neo4jTemplate neo4jTemplate;

    @Before
    public void init(){
        neo4jTemplate = new Neo4jTemplate(session);
    }

    private void emptyDatabase() {
        neo4jTemplate.deleteAll(HasFamilyName.class);
        neo4jTemplate.deleteAll(FamilyName.class);
        neo4jTemplate.deleteAll(Neo4jPerson.class);
    }

    @Test
	public void testSaveOnePersonFromMongoIntoNeo4j() {
        emptyDatabase();
        addIntoNeo4jPeopleFromMongoCollection("WO_98_Discovery_A");
        addIntoNeo4jPeopleFromMongoCollection("WO_98_Discovery_B");
        Assert.assertEquals(4, neo4jTemplate.count(Neo4jPerson.class));
        Assert.assertEquals(3, neo4jTemplate.count(FamilyName.class));
    }

    private void addIntoNeo4jPeopleFromMongoCollection(String collectionName) {
        final List<MongoPerson> people= mongoTemplate.find(
                new BasicQuery(
                        new BasicDBObject(),
                        new BasicDBObject()),
                MongoPerson.class,
                collectionName);
        Assert.assertEquals(2, people.size());
        long personIndex=1l;
        for (Person person:people){
            Neo4jPerson neo4jPerson = new Neo4jPerson(person);
            neo4jPerson.setRef(personIndex + "_" + person.getRef());

            neo4jTemplate.save(neo4jPerson, 3);
            personIndex++;
        }
    }


    public long generateNeo4jId(String name) {
        return Math.abs(new HashCodeBuilder().append(name).toHashCode());
    }

}
