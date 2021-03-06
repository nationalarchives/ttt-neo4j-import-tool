package uk.gov.nationalarchives.ttt.neo4j;

import org.apache.commons.collections.IteratorUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import uk.gov.nationalarchives.ttt.neo4j.domain.Link;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.MongoPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;
import uk.gov.nationalarchives.ttt.neo4j.service.impl.PersonGraphServiceImpl;
import uk.gov.nationalarchives.ttt.neo4j.utils.BaseTestClass;

import java.util.*;

public class TttNeo4jApplicationTests extends BaseTestClass {

    @Before
    public void initDataset(){
        emptyNeo4jDatabase();
    }

    @Test
    public void testSavePeopleAndLinksFromMongoIntoNeo4j() {
        importMongoCollectionIfMissing("WO_98_Discovery_A", "/mongo/WO_98_Discovery_A.json");
        importMongoCollectionIfMissing("WO_98_Discovery_B", "/mongo/WO_98_Discovery_B.json");
        importMongoCollectionIfMissing("link_WO98A_WO98B", "/mongo/link_WO98A_WO98B.json");

        personDocumentRepository.setPersonCollectionName("WO_98_Discovery_A");
        List<MongoPerson> people = IteratorUtils.toList(personDocumentRepository.findAll().iterator());
        for (Person person:people){
            personGraphService.savePersonGraph(person,"WO_98_Discovery_A");
        }

        personDocumentRepository.setPersonCollectionName("WO_98_Discovery_B");
        people = IteratorUtils.toList(personDocumentRepository.findAll().iterator());
        for (Person person:people){
            personGraphService.savePersonGraph(person,"WO_98_Discovery_B");
        }

        String collectionName = "link_WO98A_WO98B";
        linkRepository.setCollectionName(collectionName);
        Page<Link> page = linkRepository.findByScoreGreaterThan(0d, new PageRequest(0, 10));
        page.forEach(link -> linkService.saveLink(link, collectionName));
//        Link link = new Link();
//        link.setRefA("A_tTT000000001");
//        link.setRefB("B_tTT000000001");
//        link.setScore(10);
//        link.setSource("linker_1448473178219_1448473178239");
//        linkService.saveLink(link);

        Assert.assertEquals(4, session.query("MATCH (n:Person) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(3, session.query("MATCH (n:FamilyName) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(4, session.query("MATCH (n:ForeName) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(2, session.query("MATCH (:Person) --> (n:FamilyName) <-- (Person) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
        Assert.assertEquals(1, session.query("MATCH (a:ForeName) <-- (n:Person) --> (b:ForeName) RETURN count(DISTINCT n)", new HashMap<>()).queryResults().iterator().next().get("count(DISTINCT n)"));
        Assert.assertEquals(1, session.query("MATCH (a:Person) <-[b:LINK]-> (c:Person) RETURN count(DISTINCT b)", new
                HashMap<>()).queryResults().iterator().next().get("count(DISTINCT b)"));
    }


    @Test
    public void testSaveSinglePerson(){

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

        HasDay hasDay = new HasDay();
        Day day = new Day();
        day.setValue(31d);
        hasDay.setDay(day);
        event.setHasDay(hasDay);

        HasMonth hasMonth = new HasMonth();
        Month month = new Month();
        month.setValue(08d);
        hasMonth.setMonth(month);
        day.setHasMonth(hasMonth);

        HasYear hasYear = new HasYear();
        Year year = new Year();
        year.setValue(2015d);
        hasYear.setYear(year);
        month.setHasYear(hasYear);

        HasEvent hasEvent = new HasEvent();
        hasEvent.setEvent(event);
        person.setHasEvents(Arrays.asList(hasEvent));

        personGraphService.savePersonGraph(person, "unit_test");

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

    public static final int MAX_ELEMENTS = 20;
    public static final int PAGE_SIZE = 10;
//    public static final int MAX_ELEMENTS = 1000;
//    public static final int PAGE_SIZE = 50;

    @Test
    public void testBulkSavePeopleIntoNeo4j() throws InterruptedException {
        importMongoCollectionIfMissing("ADM337_Discovery_eval", "/mongo/ADM337_Discovery_eval.json");
        final Date start = Calendar.getInstance().getTime();

        PersonGraphServiceImpl.PAGE_SIZE=PAGE_SIZE;
        personGraphService.bulkSavePeopleGraphFromMongoCollection("ADM337_Discovery_eval", MAX_ELEMENTS);

        final Date end = Calendar.getInstance().getTime();

        final long diffSeconds = (end.getTime() - start.getTime()) / 1000 % 60;


        logger.info("testBulkSavePeopleIntoNeo4j took " + diffSeconds + " seconds with " + PersonGraphServiceImpl.NB_THREADS + "" +
                " thread(s)");

        Assert.assertEquals(MAX_ELEMENTS, session.query("MATCH (n:Person) RETURN count(n)", new HashMap<>()).queryResults().iterator().next().get("count(n)"));
    }
}
