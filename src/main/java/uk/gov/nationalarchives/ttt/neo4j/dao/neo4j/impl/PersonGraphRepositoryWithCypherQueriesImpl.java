package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl;

import org.apache.commons.collections.CollectionUtils;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.result.Result;
import org.neo4j.ogm.session.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Repository;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.PersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.Person;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcharlet on 16/11/15.
 */
@Repository
public class PersonGraphRepositoryWithCypherQueriesImpl implements PersonGraphRepository {

    private final Session session;

    private final Neo4jTemplate neo4jTemplate;

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public PersonGraphRepositoryWithCypherQueriesImpl(Session session) {
        this.session = session;
        neo4jTemplate = new Neo4jTemplate(session);


    }

    @Override
    public void createOrMergePersonGraph(Person person){
        final Transaction transaction = session.beginTransaction();
        try {
            Integer personOutputId = createPerson(person);


            if(!CollectionUtils.isEmpty(person.getHasFamilyNames())){
                for (HasFamilyName hasFamilyName : person.getHasFamilyNames()) {
                    final Integer familyNameOutputId = mergeFamilyName(hasFamilyName.getFamilyName());

                    Map<String, Object> relationshipProperties= new HashMap<>();
                    if (hasFamilyName.getOrder()!=null){
                        relationshipProperties.put("order", hasFamilyName.getOrder());
                    }
                    createRelationship(personOutputId, relationshipProperties, familyNameOutputId, "HAS_FAMILY_NAME");
                }
            }

            if(!CollectionUtils.isEmpty(person.getHasForeNames())){
                for (HasForeName hasForeName : person.getHasForeNames()) {
                    final Integer foreNameOutputId = mergeForeName(hasForeName.getForeName());

                    Map<String, Object> relationshipProperties= new HashMap<>();
                    if (hasForeName.getOrder()!=null){
                        relationshipProperties.put("order", hasForeName.getOrder());
                    }
                    createRelationship(personOutputId, relationshipProperties, foreNameOutputId, "HAS_FORE_NAME");
                }
            }

            if(!CollectionUtils.isEmpty(person.getHasReferences())){
                for (HasReference hasReference : person.getHasReferences()) {
                    final Integer referenceOutputId = mergeReference(hasReference.getReference());

                    createRelationship(personOutputId, new HashMap<String,Object>(), referenceOutputId,
                            "HAS_REFERENCE");
                }
            }

            transaction.commit();
        } catch (Exception e) {
            logger.error("an error occured while creating the person graph",e);
        } finally {
            transaction.close();
        }

    }

    private Integer mergeReference(Reference reference) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("name", reference.getName());
        if(reference.getType()!=null){
            nodeProperties.put("type", reference.getType());
        }
        if(reference.getGenre()!=null){
            nodeProperties.put("genre", reference.getGenre());
        }

        return mergeNode(reference.getClass().getSimpleName(), nodeProperties);
    }

    private Integer mergeForeName( ForeName foreName) {
        Map<String, Object> nodeProperties = new HashMap<>();
        nodeProperties.put("name", foreName.getName());
        if(foreName.getType()!=null){
            nodeProperties.put("type", foreName.getType());
        }

        return mergeNode(foreName.getClass().getSimpleName(), nodeProperties);
    }

    private Integer mergeFamilyName(FamilyName familyName) {
        HashMap<String, Object> nodeProperties = new HashMap<>();

        nodeProperties.put("name", familyName.getName());
        if(familyName.getType()!=null){
            nodeProperties.put("type", familyName.getType());
        }
        return mergeNode(familyName.getClass().getSimpleName(), nodeProperties);
    }

    private Integer createPerson(Person person) {
        Map<String, Object> personProperties = getPersonProperties(person);
        return createNode("Person", personProperties);
    }

    private void createRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("startNodeId",startNodeId);
        parameters.put("endNodeId", endNodeId);

        parameters.put("relationshipProperties", relationshipProperties);

        session.query(
                "MATCH (startNode), " +
                        "(endNode)" +
                        "WHERE id(startNode)={startNodeId} AND id(endNode)={endNodeId}" +
                        "CREATE (startNode) -[:" + relationshipLabel + " {relationshipProperties}]-> (endNode)",
                parameters);
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
        String cypherQuery = saveType + " (n:" + nodeType + " {";
        for (String parameterKey : nodeProperties.keySet()) {
            cypherQuery+=parameterKey+":{"+parameterKey+"},";
        }
        cypherQuery=cypherQuery.substring(0, cypherQuery.length()-1);
        cypherQuery+="}) RETURN ID(n)";

        final Result mergeResult = session.query(
                cypherQuery,
                nodeProperties);
        return getSingleNodeIdFromQueryResults(mergeResult);
    }

    private Map<String, Object> getPersonProperties(Person person) {
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("ref", person.getRef());

        if(person.getType()!= null && person.getType()!= Person.Type.UNKNOWN){
            personMap.put("type", person.getType());
        }
        if(person.getTimestamp()!=null){
            personMap.put("timestamp", person.getTimestamp());
        }
        return personMap;
    }

}
