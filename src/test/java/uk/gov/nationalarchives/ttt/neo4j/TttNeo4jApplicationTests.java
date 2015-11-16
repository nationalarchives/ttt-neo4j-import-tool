package uk.gov.nationalarchives.ttt.neo4j;

import com.mongodb.BasicDBObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.MongoPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Person;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.FamilyName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.ForeName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasFamilyName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasForeName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    @Autowired
    PersonGraphRepository personGraphRepository;

    @Before
    public void init(){
        neo4jTemplate = new Neo4jTemplate(session);
    }

    private void emptyDatabase() {
        neo4jTemplate.deleteAll(HasForeName.class);
        neo4jTemplate.deleteAll(ForeName.class);
        neo4jTemplate.deleteAll(HasFamilyName.class);
        neo4jTemplate.deleteAll(FamilyName.class);
        neo4jTemplate.deleteAll(Neo4jPerson.class);
    }

    @Test
	public void testSavePeopleFromMongoIntoNeo4j() {
        emptyDatabase();
        addIntoNeo4jPeopleFromMongoCollection("WO_98_Discovery_A");
        addIntoNeo4jPeopleFromMongoCollection("WO_98_Discovery_B");

        Assert.assertEquals(4, neo4jTemplate.count(Neo4jPerson.class));
        Assert.assertEquals(3, neo4jTemplate.count(FamilyName.class));
        Assert.assertEquals(4, neo4jTemplate.count(ForeName.class));
        assert2peopleHaveAFamilyNameInCommon();
        assert1personHas2Forenames();
    }

    @Test
    public void testSave1PersonWith1ForeName(){
        emptyDatabase();


        Neo4jPerson person = new Neo4jPerson();
        person.setRef("TEST_1");

//        FamilyName familyName = new FamilyName();
//        familyName.setName("Dupond");
//        HasFamilyName hasFamilyName = new HasFamilyName();
//        hasFamilyName.setFamilyName(familyName);
//        person.setHasFamilyNames(Arrays.asList(hasFamilyName));

        ForeName foreName = new ForeName();
        foreName.setName("Jean");
        HasForeName hasForeName = new HasForeName();
        hasForeName.setForeName(foreName);
        person.setHasForeNames(Arrays.asList(hasForeName));

        personGraphRepository.createOrMergePersonGraph(person);
        Assert.assertEquals(1, neo4jTemplate.count(Neo4jPerson.class));
        Assert.assertEquals(1, neo4jTemplate.count(ForeName.class));

        final Neo4jPerson retrievedPerson =
                neo4jTemplate.queryForObject(
                        Neo4jPerson.class,
                        "match (person) --> (m:ForeName {name:{name}}) return person",
                        new HashMap<String, String>() {{
                            put("name", "Jean");
                        }});

        Assert.assertNotNull(retrievedPerson);
        Assert.assertEquals("TEST_1", retrievedPerson.getRef());
    }

    private void assert1personHas2Forenames() {
        final Iterable<ForeName> foreNamesFrom1person =
                neo4jTemplate.queryForObjects(
                        ForeName.class,
                        "match (foreName:ForeName) <-- (:Neo4jPerson) --> (foreName2:ForeName) return foreName, foreName2",
                        new HashMap<String, String>(){{put("name","barton");
                        }});

        List<ForeName> forenameList = new ArrayList<>();
        foreNamesFrom1person.forEach(forenameList::add);
        Assert.assertEquals(2, forenameList.size());
    }

    private void assert2peopleHaveAFamilyNameInCommon() {
        final Iterable<Neo4jPerson> peopleWithNameBarton =
                neo4jTemplate.queryForObjects(
                        Neo4jPerson.class,
                        "match (person) --> (m:FamilyName {name:{name}}) return person",
                        new HashMap<String, String>(){{put("name","barton");
        }});

        List<Neo4jPerson> neo4jPersonList = new ArrayList<>();
        peopleWithNameBarton.forEach(neo4jPersonList::add);
        Assert.assertEquals(2, neo4jPersonList.size());
    }

    private void addIntoNeo4jPeopleFromMongoCollection(String collectionName) {
        final List<MongoPerson> people= mongoTemplate.find(
                new BasicQuery(
                        new BasicDBObject(),
                        new BasicDBObject()),
                MongoPerson.class,
                collectionName);
        Assert.assertEquals(2, people.size());
        for (Person person:people){
            personGraphRepository.createOrMergePersonGraph(person);
        }
    }


    public long generateNeo4jId(String name) {
        return Math.abs(new HashCodeBuilder().append(name).toHashCode());
    }

}
