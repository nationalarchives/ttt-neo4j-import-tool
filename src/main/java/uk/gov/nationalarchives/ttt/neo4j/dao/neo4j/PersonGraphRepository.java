package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j;


import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface PersonGraphRepository {
    Integer mergeDateNodesAndTheirSubRelationships(Year year, Month month, Day day);

    Integer createPerson(Person person);

    Integer mergeFamilyName(FamilyName familyName);

    void createRelationshipBetweenPersonAndFamilyName(Integer personOutputId, HasFamilyName hasFamilyName, Integer familyNameOutputId);

    Integer mergeForeName(ForeName foreName);

    void createRelationshipBetweenPersonAndForeName(Integer personOutputId, HasForeName hasForeName, Integer foreNameOutputId);

    Integer mergeReference(Reference reference);

    Integer createEvent(Event event);

    void createEventToDateRelationship(Integer eventOutputId, HashMap<String, Object> stringObjectHashMap, Integer dateOutputId, Year year, Month month, Day day);

    Integer mergeDocument(Document document);

    Integer mergeSource(Source source);

    void createRelationship(Integer startNodeId, Map<String, Object> relationshipProperties, Integer endNodeId, String relationshipLabel);

    void emptyGraphDatabase();
}
