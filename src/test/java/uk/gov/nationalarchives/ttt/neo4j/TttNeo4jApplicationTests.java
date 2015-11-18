package uk.gov.nationalarchives.ttt.neo4j;

import com.mongodb.BasicDBObject;
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
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl.PersonGraphRepositoryWithCypherQueriesImpl;
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

    @Autowired
    PersonGraphRepositoryWithCypherQueriesImpl personGraphRepositoryWithCypherQueries;

    @Before
    public void init(){
        neo4jTemplate = new Neo4jTemplate(session);
    }

    private void emptyDatabase() {
        neo4jTemplate.query("MATCH (n) DETACH DELETE n", new HashMap<String,Object>());
    }

    @Test
    public void testSavePeopleFromMongoIntoNeo4jWithCypherQueries() {
        emptyDatabase();

        List<MongoPerson> people = new ArrayList<>();
        people.addAll(getPeopleFromMongoCollection("WO_98_Discovery_A"));
        people.addAll(getPeopleFromMongoCollection("WO_98_Discovery_B"));
        Assert.assertEquals(4, people.size());

        for (Person person:people){
            personGraphRepositoryWithCypherQueries.createOrMergePersonGraph(person);
        }

        Assert.assertEquals(4, session.query("MATCH (n:Person) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(3, session.query("MATCH (n:FamilyName) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(4, session.query("MATCH (n:ForeName) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(2, session.query("MATCH (:Person) --> (n:FamilyName) <-- (Person) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(1, session.query("MATCH (a:ForeName) <-- (n:Person) --> (b:ForeName) RETURN count(DISTINCT n)", new HashMap<>()).queryResults().iterator().next().get("count(DISTINCT n)"));
    }

    @Test
    public void testSavePeopleFromMongoIntoNeo4j() {
        emptyDatabase();

        List<MongoPerson> people = new ArrayList<>();
        people.addAll(getPeopleFromMongoCollection("WO_98_Discovery_A"));
        people.addAll(getPeopleFromMongoCollection("WO_98_Discovery_B"));
        Assert.assertEquals(4, people.size());

        for (Person person:people){
            personGraphRepository.createOrMergePersonGraph(person);
        }

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

    private List<MongoPerson> getPeopleFromMongoCollection(String collectionName) {
        return mongoTemplate.find(
                new BasicQuery(
                        new BasicDBObject(),
                        new BasicDBObject()),
                MongoPerson.class,
                collectionName);

    }


    public long generateNeo4jId(String name) {
        return Math.abs(new HashCodeBuilder().append(name).toHashCode());
    }

}
