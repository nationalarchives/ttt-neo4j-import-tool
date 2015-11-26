package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.result.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcharlet on 11/25/15.
 */
public abstract class GenericGraphRepository {
    protected final Session session;

    protected GenericGraphRepository(Session session) {
        this.session = session;
    }

    protected void saveRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel, String saveCommand) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("startNodeId", startNodeId);
        parameters.put("endNodeId", endNodeId);

        parameters.putAll(relationshipProperties);

        String cypherQuery = "MATCH (startNode), " +
                "(endNode)" +
                "WHERE id(startNode)={startNodeId} AND id(endNode)={endNodeId}" +
                saveCommand;
        cypherQuery += " (startNode) -[:" + relationshipLabel + " { ";

        for (String parameterKey : relationshipProperties.keySet()) {
            cypherQuery += parameterKey + ":{" + parameterKey + "},";
        }
        cypherQuery = cypherQuery.substring(0, cypherQuery.length() - 1);

        cypherQuery += "}]-> (endNode)";

        session.query(
                cypherQuery,
                parameters);
    }


    protected void saveBothWaysRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer
            endNodeId, String relationshipLabel, String saveCommand) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("startNodeId", startNodeId);
        parameters.put("endNodeId", endNodeId);

        parameters.putAll(relationshipProperties);

        String cypherQuery = "MATCH (startNode), " +
                "(endNode)" +
                "WHERE id(startNode)={startNodeId} AND id(endNode)={endNodeId}" +
                saveCommand;
        cypherQuery += " (startNode) <-[:" + relationshipLabel + " { ";

        for (String parameterKey : relationshipProperties.keySet()) {
            cypherQuery += parameterKey + ":{" + parameterKey + "},";
        }
        cypherQuery = cypherQuery.substring(0, cypherQuery.length() - 1);

        cypherQuery += "}]-> (endNode)";

        session.query(
                cypherQuery,
                parameters);
    }

    protected void createRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer
            endNodeId,String relationshipLabel) {
        saveRelationship(startNodeId, relationshipProperties, endNodeId, relationshipLabel, "CREATE");
    }

    protected void mergeRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel) {
        saveRelationship(startNodeId, relationshipProperties, endNodeId, relationshipLabel, "MERGE");
    }

    protected void mergeBothWaysRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer
            endNodeId, String relationshipLabel) {
        saveBothWaysRelationship(startNodeId, relationshipProperties, endNodeId, relationshipLabel, "MERGE");
    }

    protected Integer getSingleNodeIdFromQueryResults(Result creationResult) {
        return (Integer) creationResult.queryResults().iterator().next().get("ID(n)");
    }

    protected Integer mergeNode(final String nodeType, Map<String, Object> nodeProperties) {
        String saveType = "MERGE";
        return saveNode(nodeType, nodeProperties, saveType);
    }

    protected Integer createNode(final String nodeType, Map<String, Object> nodeProperties) {
        String saveType = "CREATE";
        return saveNode(nodeType, nodeProperties, saveType);
    }

    protected Integer saveNode(String nodeType, Map<String, Object> nodeProperties, String saveType) {
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
}
