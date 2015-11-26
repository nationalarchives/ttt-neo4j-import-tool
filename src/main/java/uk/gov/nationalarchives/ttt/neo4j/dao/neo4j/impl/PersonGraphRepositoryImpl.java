package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jcharlet on 16/11/15.
 */
@Repository
public class PersonGraphRepositoryImpl extends GenericGraphRepository implements PersonGraphRepository  {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public PersonGraphRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Integer mergeDateNodesAndTheirSubRelationships(Year year, Month month, Day day) {
        try {
            if (day != null) {
                Month monthFromCompleteDate = day.getHasMonth().getMonth();
                Year yearFromCompleteDate = monthFromCompleteDate.getHasYear().getYear();

                final Integer yearId = mergeYear(yearFromCompleteDate);

                final Integer monthId = mergeMonth(yearFromCompleteDate,
                        monthFromCompleteDate);
                mergeRelationship(monthId, new HashMap<String, Object>(), yearId,
                        "HAS_YEAR");

                final Integer dayId = mergeDay(yearFromCompleteDate,
                        monthFromCompleteDate,
                        day);
                mergeRelationship(dayId, new HashMap<String, Object>(), monthId,
                        "HAS_MONTH");
                return dayId;

            } else if (month != null) {
                Year yearFromPartialDate = month.getHasYear().getYear();
                final Integer yearId = mergeYear(yearFromPartialDate);

                final Integer monthId = mergeMonth(yearFromPartialDate, month);

                mergeRelationship(monthId, new HashMap<String, Object>(), yearId,
                        "HAS_YEAR");
                return monthId;

            }
            final Integer yearId = mergeYear(year);
            return yearId;


        } catch (NullPointerException e) {
            throw new IllegalArgumentException("the date was incorrectly formatted and thus raised a NPE", e);
        }

    }

    protected Integer mergeDay(Year year, Month month, Day day) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("value", day.getValue());
        nodeProperties.put("month", month.getValue());
        nodeProperties.put("year", year.getValue());

        return mergeNode(day.getClass().getSimpleName(), nodeProperties);
    }

    protected Integer mergeMonth(Year year, Month month) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("value", month.getValue());
        nodeProperties.put("year", year.getValue());

        return mergeNode(month.getClass().getSimpleName(), nodeProperties);
    }

    protected Integer mergeYear(Year node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("value", node.getValue());

        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    @Override
    public void createEventToDateRelationship(Integer eventOutputId, HashMap<String, Object> stringObjectHashMap, Integer dateOutputId, Year year, Month month, Day day) {
        if (day != null) {
            createRelationship(eventOutputId, new HashMap<String, Object>(), dateOutputId,
                    "HAS_DAY");
        } else if (month != null) {
            createRelationship(eventOutputId, new HashMap<String, Object>(), dateOutputId,
                    "HAS_MONTH");
        } else {
            createRelationship(eventOutputId, new HashMap<String, Object>(), dateOutputId,
                    "HAS_YEAR");
        }
    }

    @Override
    public Integer createEvent(Event node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }
        if (node.getGenre() != null) {
            nodeProperties.put("genre", node.getGenre());
        }

        return createNode(node.getClass().getSimpleName(), nodeProperties);
    }

    @Override
    public void createRelationshipBetweenPersonAndForeName(Integer personOutputId, HasForeName hasForeName, Integer foreNameOutputId) {
        Map<String, Object> relationshipProperties = new HashMap<>();
        if (hasForeName.getOrder() != null) {
            relationshipProperties.put("order", hasForeName.getOrder());
        }
        createRelationship(personOutputId, relationshipProperties, foreNameOutputId, "HAS_FORE_NAME");
    }

    @Override
    public void createRelationshipBetweenPersonAndFamilyName(Integer personOutputId, HasFamilyName hasFamilyName, Integer familyNameOutputId) {
        Map<String, Object> relationshipProperties = new HashMap<>();
        if (hasFamilyName.getOrder() != null) {
            relationshipProperties.put("order", hasFamilyName.getOrder());
        }
        createRelationship(personOutputId, relationshipProperties, familyNameOutputId, "HAS_FAMILY_NAME");
    }

    @Override
    public Integer mergeSource(Source node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("name", node.getName());
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }
        if (node.getRef() != null) {
            nodeProperties.put("genre", node.getRef());
        }

        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    @Override
    public Integer mergeDocument(Document node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("name", node.getName());
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }
        if (node.getRef() != null) {
            nodeProperties.put("genre", node.getRef());
        }
        if (node.getURL() != null) {
            nodeProperties.put("URL", node.getURL());
        }

        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    @Override
    public Integer mergeReference(Reference node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("name", node.getName());
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }
        if (node.getGenre() != null) {
            nodeProperties.put("genre", node.getGenre());
        }

        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    @Override
    public Integer mergeForeName(ForeName node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("name", node.getName());
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }

        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    @Override
    public Integer mergeFamilyName(FamilyName node) {
        HashMap<String, Object> nodeProperties = new HashMap<>();

        nodeProperties.put("name", node.getName());
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }
        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    @Override
    public Integer createPerson(Person person, String source) {
        Map<String, Object> personProperties = getPersonProperties(person);
        personProperties.put("source",source);
        return createNode("Person", personProperties);
    }


    //FIXME JCT to move into genericGraphRepo
    @Override
    public void createRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel) {
        saveRelationship(startNodeId, relationshipProperties, endNodeId, relationshipLabel, "CREATE");
    }

    @Override
    public void emptyGraphDatabase() {
        session.query("MATCH (n) DETACH DELETE n", new HashMap<String,Object>());
    }

    @Override
    public Integer findPersonByRef(String ref) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("ref", ref);
        Iterator<Map<String, Object>> resultsIterator = session.query("MATCH (n:Person) WHERE n.ref={ref} RETURN ID(n)", parameters)
                .queryResults().iterator();
        if (resultsIterator.hasNext()){
            return (Integer) resultsIterator.next().get("ID(n)");
        }
        return null;
    }

    @Override
    public void removePeopleFromSource(String source) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("source",source);
        session.query("MATCH (n:Person) WHERE n.source={source} DETACH DELETE n", parameters);
    }

    @Override
    public void removeReferencesWithoutRelationshipToPerson() {
        removeNodesWithoutRelationshipTo(Reference.class.getSimpleName(), Person.class.getSimpleName());
    }

    private void removeNodesWithoutRelationshipTo(String sourceLabel, String targetLabel) {
        session.query("MATCH (n:"+sourceLabel+") WHERE NOT (n)--(:"+targetLabel+") DETACH DELETE n", new HashMap<>());
    }

    @Override
    public void removeForeNamesWithoutRelationshipToPerson() {
        removeNodesWithoutRelationshipTo(ForeName.class.getSimpleName(), Person.class.getSimpleName());
    }

    @Override
    public void removeFamilyNamesWithoutRelationshipToPerson() {
        removeNodesWithoutRelationshipTo(FamilyName.class.getSimpleName(), Person.class.getSimpleName());
    }

    @Override
    public void removeEventsWithoutRelationshipToPerson() {
        removeNodesWithoutRelationshipTo(Event.class.getSimpleName(), Person.class.getSimpleName());
    }

    @Override
    public void removeDocumentsWithoutRelationshipToPerson() {
        removeNodesWithoutRelationshipTo(Document.class.getSimpleName(), Person.class.getSimpleName());
    }

    private Map<String, Object> getPersonProperties(Person person) {
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("ref", person.getRef());

        if (person.getType() != null && person.getType() != Person.Type.UNKNOWN) {
            personMap.put("type", person.getType());
        }
        if (person.getTimestamp() != null) {
            personMap.put("timestamp", person.getTimestamp());
        }
        return personMap;
    }

}
