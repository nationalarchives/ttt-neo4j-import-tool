package uk.gov.nationalarchives.ttt.neo4j;

import com.mongodb.BasicDBObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.constants.EventType;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;

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

    @Autowired
    PersonGraphRepository personGraphRepository;

    private void emptyDatabase() {
        session.query("MATCH (n) DETACH DELETE n", new HashMap<String,Object>());
    }

    @Test
    public void testSavePeopleFromMongoIntoNeo4j() {
        emptyDatabase();

        List<Person> people = new ArrayList<>();
        people.addAll(getPeopleFromMongoCollection("WO_98_Discovery_A"));
        people.addAll(getPeopleFromMongoCollection("WO_98_Discovery_B"));
        Assert.assertEquals(4, people.size());

        for (Person person:people){
            personGraphRepository.createOrMergePersonGraph(person);
        }

        Assert.assertEquals(4, session.query("MATCH (n:Person) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(3, session.query("MATCH (n:FamilyName) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(4, session.query("MATCH (n:ForeName) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(2, session.query("MATCH (:Person) --> (n:FamilyName) <-- (Person) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(1, session.query("MATCH (a:ForeName) <-- (n:Person) --> (b:ForeName) RETURN count(DISTINCT n)", new HashMap<>()).queryResults().iterator().next().get("count(DISTINCT n)"));
    }


    @Test
    public void testSaveSinglePerson(){
        emptyDatabase();


        Person person = new Person();
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

        Event event = new Event();
        event.setType("BIRTH");

        HasYear hasYear = new HasYear();
        Year year = new Year();
        year.setValue(2015d);
        hasYear.setYear(year);
        event.setHasYear(hasYear);

        HasMonth hasMonth = new HasMonth();
        Month month = new Month();
        month.setValue(08d);
        hasMonth.setMonth(month);
        event.setHasMonth(hasMonth);


        HasDay hasDay = new HasDay();
        Day day = new Day();
        day.setValue(31d);
        hasDay.setDay(day);
        event.setHasDay(hasDay);

        HasEvent hasEvent = new HasEvent();
        hasEvent.setEvent(event);
        person.setHasEvents(Arrays.asList(hasEvent));

        personGraphRepository.createOrMergePersonGraph(person);

        Assert.assertEquals(1, session.query("MATCH (n:Person) RETURN count(n)", new HashMap<>()).queryResults()
                .iterator().next().get("count(n)"));
        Assert.assertEquals(1, session.query("MATCH (n:ForeName) RETURN count(n)", new HashMap<>()).queryResults()
                .iterator().next().get("count(n)"));
        Assert.assertEquals(1, session.query(
                "match (n:Person) --> (m:ForeName {name:{name}}) return count(DISTINCT n)",
                new HashMap<String, String>() {{
                    put("name", "Jean");
                }})
                .queryResults().iterator().next().get("count(DISTINCT n)"));
    }

    private List<Person> getPeopleFromMongoCollection(String collectionName) {
        return mongoTemplate.find(
                new BasicQuery(
                        new BasicDBObject(),
                        new BasicDBObject()),
                Person.class,
                collectionName);

    }


    public long generateNeo4jId(String name) {
        return Math.abs(new HashCodeBuilder().append(name).toHashCode());
    }

}
