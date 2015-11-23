package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl;

import org.apache.commons.collections.CollectionUtils;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.result.Result;
import org.neo4j.ogm.session.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcharlet on 16/11/15.
 */
@Repository
public class PersonGraphRepositoryImpl implements PersonGraphRepository {

    private final Session session;

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public PersonGraphRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void createOrMergePersonGraph(Person person) {
        final Transaction transaction = session.beginTransaction();
        try {
            Integer personOutputId = createPerson(person);


            if (!CollectionUtils.isEmpty(person.getHasFamilyNames())) {
                for (HasFamilyName hasFamilyName : person.getHasFamilyNames()) {
                    final Integer familyNameOutputId = mergeFamilyName(hasFamilyName.getFamilyName());

                    createRelationshipBetweenPersonAndFamilyName(personOutputId, hasFamilyName, familyNameOutputId);
                }
            }

            if (!CollectionUtils.isEmpty(person.getHasForeNames())) {
                for (HasForeName hasForeName : person.getHasForeNames()) {
                    final Integer foreNameOutputId = mergeForeName(hasForeName.getForeName());

                    createRelationshipBetweenPersonAndForeName(personOutputId, hasForeName, foreNameOutputId);
                }
            }


            if (!CollectionUtils.isEmpty(person.getHasReferences())) {
                for (HasReference hasReference : person.getHasReferences()) {
                    final Integer referenceOutputId = mergeReference(hasReference.getReference());

                    createRelationship(personOutputId, new HashMap<String, Object>(), referenceOutputId,
                            "HAS_REFERENCE");
                }
            }

            if (!CollectionUtils.isEmpty(person.getHasEvents())) {
                for (HasEvent hasEvent : person.getHasEvents()) {
                    if (hasEvent.getEvent().getHasYear() == null) {
                        continue;
                    }

                    final Integer eventOutputId = createEvent(hasEvent.getEvent());

                    createRelationship(personOutputId, new HashMap<String, Object>(), eventOutputId,
                            "HAS_EVENT");

                    Year year = null;
                    if (hasEvent.getEvent().getHasYear() != null) {
                        year = hasEvent.getEvent().getHasYear().getYear();
                    }
                    Month month = null;
                    if (hasEvent.getEvent().getHasMonth() != null) {
                        month = hasEvent.getEvent().getHasMonth().getMonth();
                    }
                    Day day = null;
                    if (hasEvent.getEvent().getHasDay() != null) {
                        day = hasEvent.getEvent().getHasDay().getDay();
                    }

                    final Integer dateOutputId = mergeDateNodesAndTheirSubRelationships(year, month, day);

                    createEventToDateRelationship(eventOutputId, new HashMap<String, Object>(), dateOutputId, year, month, day);
                }

            }

            if (person.getInContainer() != null) {
                InContainer inContainer = person.getInContainer();
                if (inContainer.getDocument() != null) {
                    final Integer documentId = mergeDocument(inContainer.getDocument());

                    createRelationship(personOutputId, new HashMap<String, Object>(), documentId,
                            "IN_CONTAINER");
                }
                if (inContainer.getSource() != null) {
                    final Integer sourceId = mergeSource(inContainer.getSource());

                    createRelationship(personOutputId, new HashMap<String, Object>(), sourceId,
                            "IN_CONTAINER");
                }
            }

            transaction.commit();
        } catch (Exception e) {
            logger.error("an error occured while creating the person graph", e);
        } finally {
            transaction.close();
        }

    }

    private Integer mergeDateNodesAndTheirSubRelationships(Year year, Month month, Day day) {
        final Integer dateOutputId = null;

        final Integer yearId = mergeYear(year);

        if (month == null) {
            return yearId;
        }

        final Integer monthId = mergeMonth(year, month);
        mergeRelationship(monthId, new HashMap<String, Object>(), yearId,
                "HAS_YEAR");

        if (day == null) {
            return monthId;
        }

        final Integer dayId = mergeDay(year, month, day);
        mergeRelationship(dayId, new HashMap<String, Object>(), monthId,
                "HAS_MONTH");
        return dayId;
    }

    private Integer mergeDay(Year year, Month month, Day day) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("value", day.getValue());
        nodeProperties.put("month", month.getValue());
        nodeProperties.put("year", year.getValue());

        return createNode(day.getClass().getSimpleName(), nodeProperties);
    }

    private Integer mergeMonth(Year year, Month month) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("value", month.getValue());
        nodeProperties.put("year", year.getValue());

        return createNode(month.getClass().getSimpleName(), nodeProperties);
    }

    private Integer mergeYear(Year node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("value", node.getValue());

        return createNode(node.getClass().getSimpleName(), nodeProperties);
    }

    private void createEventToDateRelationship(Integer eventOutputId, HashMap<String, Object> stringObjectHashMap, Integer dateOutputId, Year year, Month month, Day day) {
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

    private Integer createEvent(Event node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }
        if (node.getGenre() != null) {
            nodeProperties.put("genre", node.getGenre());
        }

        return createNode(node.getClass().getSimpleName(), nodeProperties);
    }

    private void createRelationshipBetweenPersonAndForeName(Integer personOutputId, HasForeName hasForeName, Integer foreNameOutputId) {
        Map<String, Object> relationshipProperties = new HashMap<>();
        if (hasForeName.getOrder() != null) {
            relationshipProperties.put("order", hasForeName.getOrder());
        }
        createRelationship(personOutputId, relationshipProperties, foreNameOutputId, "HAS_FORE_NAME");
    }

    private void createRelationshipBetweenPersonAndFamilyName(Integer personOutputId, HasFamilyName hasFamilyName, Integer familyNameOutputId) {
        Map<String, Object> relationshipProperties = new HashMap<>();
        if (hasFamilyName.getOrder() != null) {
            relationshipProperties.put("order", hasFamilyName.getOrder());
        }
        createRelationship(personOutputId, relationshipProperties, familyNameOutputId, "HAS_FAMILY_NAME");
    }

    private Integer mergeSource(Source node) {
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

    private Integer mergeDocument(Document node) {
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

    private Integer mergeReference(Reference node) {
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

    private Integer mergeForeName(ForeName node) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("name", node.getName());
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }

        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    private Integer mergeFamilyName(FamilyName node) {
        HashMap<String, Object> nodeProperties = new HashMap<>();

        nodeProperties.put("name", node.getName());
        if (node.getType() != null) {
            nodeProperties.put("type", node.getType());
        }
        return mergeNode(node.getClass().getSimpleName(), nodeProperties);
    }

    private Integer createPerson(Person person) {
        Map<String, Object> personProperties = getPersonProperties(person);
        return createNode("Person", personProperties);
    }

    private void saveRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel, String saveCommand) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("startNodeId", startNodeId);
        parameters.put("endNodeId", endNodeId);

        parameters.putAll(relationshipProperties);

        String cypherQuery = "MATCH (startNode), " +
                "(endNode)" +
                "WHERE id(startNode)={startNodeId} AND id(endNode)={endNodeId}" +
                saveCommand;
        cypherQuery+=" (startNode) -[:" + relationshipLabel + " { ";

        for (String parameterKey : relationshipProperties.keySet()) {
            cypherQuery += parameterKey + ":{" + parameterKey + "},";
        }
        cypherQuery = cypherQuery.substring(0, cypherQuery.length() - 1);

        cypherQuery+="}]-> (endNode)";

        session.query(
                cypherQuery,
                parameters);
    }

    private void createRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel) {
        saveRelationship(startNodeId, relationshipProperties, endNodeId, relationshipLabel, "CREATE");
    }

    private void mergeRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel) {
        saveRelationship(startNodeId, relationshipProperties, endNodeId, relationshipLabel, "MERGE");
    }

    private Integer getSingleNodeIdFromQueryResults(Result creationResult) {
        return (Integer) creationResult.queryResults().iterator().next().get("ID(n)");
    }

    private Integer mergeNode(final String nodeType, Map<String, Object> nodeProperties) {
        String saveType = "MERGE";
        return saveNode(nodeType, nodeProperties, saveType);
    }

    private Integer createNode(final String nodeType, Map<String, Object> nodeProperties) {
        String saveType = "CREATE";
        return saveNode(nodeType, nodeProperties, saveType);
    }

    private Integer saveNode(String nodeType, Map<String, Object> nodeProperties, String saveType) {
        String cypherQuery = saveType + " (n:" + nodeType + " { ";
        for (String parameterKey : nodeProperties.keySet()) {
            cypherQuery += parameterKey + ":{" + parameterKey + "},";
        }
        cypherQuery = cypherQuery.substring(0, cypherQuery.length() - 1);
        cypherQuery += "}) RETURN ID(n)";

        final Result saveResult = session.query(
                cypherQuery,
                nodeProperties);
        return getSingleNodeIdFromQueryResults(saveResult);
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
