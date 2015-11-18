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
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jObject;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Person;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.FamilyName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.ForeName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasFamilyName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasForeName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcharlet on 16/11/15.
 */
@Repository
public class PersonGraphRepositoryWithCypherQueriesImpl {

    private final Session session;

    private final Neo4jTemplate neo4jTemplate;

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public PersonGraphRepositoryWithCypherQueriesImpl(Session session) {
        this.session = session;
        neo4jTemplate = new Neo4jTemplate(session);


    }

    public void createOrMergePersonGraph(Person person){
        final Transaction transaction = session.beginTransaction();

        Integer personOutputId = createPerson(person);


        if(!CollectionUtils.isEmpty(person.getHasFamilyNames())){
            for (HasFamilyName hasFamilyName : person.getHasFamilyNames()) {
                final FamilyName inputFamilyName = hasFamilyName.getFamilyName();
                final Integer familyNameOutputId = mergeFamilyName(inputFamilyName);

                mergeRelationshipFromPersonToFamilyName(personOutputId, hasFamilyName, familyNameOutputId);
            }
        }

        if(!CollectionUtils.isEmpty(person.getHasForeNames())){
            for (HasForeName hasForeName : person.getHasForeNames()) {
                final ForeName inputForeName = hasForeName.getForeName();
                final Integer foreNameOutputId = mergeForeName(inputForeName);

                mergeRelationshipFromPersonToForeName(personOutputId, hasForeName, foreNameOutputId);
            }
        }

        transaction.commit();

        transaction.close();
    }

    private void mergeRelationshipFromPersonToFamilyName(Integer personOutputId, HasFamilyName hasFamilyName, Integer familyNameOutputId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("personOutputId",personOutputId);
        parameters.put("familyNameOutputId", familyNameOutputId);
        parameters.put("order", hasFamilyName.getOrder());

        session.query(
                "MATCH (person:Person), " +
                        "(familyName:FamilyName)" +
                        "WHERE id(person)={personOutputId} AND id(familyName)={familyNameOutputId}" +
                        "MERGE (person) -[:HAS_FAMILY_NAME {order:{order}}]-> (familyName)",
                parameters);
    }

    private void mergeRelationshipFromPersonToForeName(Integer personOutputId, HasForeName hasForeName, Integer foreNameOutputId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("personOutputId",personOutputId);
        parameters.put("foreNameOutputId", foreNameOutputId);
        parameters.put("order", hasForeName.getOrder());

        session.query(
                "MATCH (person:Person), " +
                        "(foreName:ForeName)" +
                        "WHERE id(person)={personOutputId} AND id(foreName)={foreNameOutputId}" +
                        "MERGE (person) -[:HAS_FORE_NAME {order:{order}}]-> (foreName)",
                parameters);
    }

    private Integer createPerson(Person person) {
        Map<String, Object> personMap = getPersonMap(person);

        final Result creationResult = session.query(
                "CREATE (n:Person {props}) RETURN ID(n)",
                getCypherQueryParameters(personMap));
        return (Integer) creationResult.queryResults().iterator().next().get("ID(n)");
    }

    private Integer mergeFamilyName(FamilyName inputFamilyName) {
        String cypherQuery = "MERGE (n:FamilyName {";
        Map<String, Object> parameters = new HashMap<>();

        cypherQuery+="name:{name}";
        parameters.put("name", inputFamilyName.getName());

        if(inputFamilyName.getType()!=null){
            cypherQuery+=",type:{type}";
            parameters.put("type", inputFamilyName.getType());
        }

        cypherQuery+="}) RETURN ID(n)";

        final Result mergeResult = session.query(
                cypherQuery,
                parameters);
        return (Integer) mergeResult.queryResults().iterator().next().get("ID(n)");
    }

    private Integer mergeForeName(ForeName inputForeName) {
        String cypherQuery = "MERGE (n:ForeName {";
        Map<String, Object> parameters = new HashMap<>();

        cypherQuery+="name:{name}";
        parameters.put("name", inputForeName.getName());

        if(inputForeName.getType()!=null){
            cypherQuery+=",type:{type}";
            parameters.put("type", inputForeName.getType());
        }

        cypherQuery+="}) RETURN ID(n)";

        final Result mergeResult = session.query(
                cypherQuery,
                parameters);
        return (Integer) mergeResult.queryResults().iterator().next().get("ID(n)");
    }

    private Map<String, Object> getCypherQueryParameters(Map<String, Object> personMap) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("props",personMap);
        return parameters;
    }

    private Map<String, Object> getPersonMap(Person person) {
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
