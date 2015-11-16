package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.CustomPersonGraphRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jObject;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jPerson;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Person;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.FamilyName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.ForeName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasFamilyName;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasForeName;

/**
 * Created by jcharlet on 16/11/15.
 */
public class PersonGraphRepositoryImpl implements CustomPersonGraphRepository{

    private final Session session;

    private final Neo4jTemplate neo4jTemplate;

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public PersonGraphRepositoryImpl(Session session) {
        this.session = session;
        neo4jTemplate = new Neo4jTemplate(session);
    }

    @Override
    public Neo4jPerson createOrMergePersonGraph(Person person){
        Neo4jPerson neo4jPerson = new Neo4jPerson(person);

        neo4jPerson= (Neo4jPerson) saveSingleNode(neo4jPerson);

        for (HasFamilyName hasFamilyName : neo4jPerson.getHasFamilyNames()) {
            final FamilyName inputFamilyName = hasFamilyName.getFamilyName();
            FamilyName familyName = getFromPropertyOrCreateNode(
                    FamilyName.class, "name", inputFamilyName.getName(), inputFamilyName);
            hasFamilyName.setFamilyName(familyName);
            hasFamilyName.setPerson(neo4jPerson);
        }

        for (HasForeName hasForeName : neo4jPerson.getHasForeNames()) {
            final ForeName inputForeName = hasForeName.getForeName();
            ForeName foreName = getFromPropertyOrCreateNode(
                    ForeName.class, "name", inputForeName.getName(), inputForeName);
            hasForeName.setForeName(foreName);
            hasForeName.setPerson(neo4jPerson);
        }
        neo4jPerson=(Neo4jPerson)saveNodeAndItsRelationships(neo4jPerson,1);
        return neo4jPerson;
    }

    private Neo4jObject saveSingleNode(Neo4jObject neo4jObject) {
        return neo4jTemplate.save(neo4jObject,0);
    }

    private Neo4jObject saveNodeAndItsRelationships(Neo4jObject neo4jObject, int depth) {
        return neo4jTemplate.save(neo4jObject,depth);
    }

    private <T extends Neo4jObject> T getFromPropertyOrCreateNode(Class<T> inputNodeClass,String property, String value, T inputNode) {
        T outputNode;

        T retrievedNode = findUniqueNodeByTypeAndProperty(inputNodeClass, property, value);

        if (retrievedNode==null){
            outputNode= (T) saveSingleNode(inputNode);
        }else{
            outputNode=retrievedNode;
        }
        return outputNode;
    }

    private <T extends Neo4jObject> T findUniqueNodeByTypeAndProperty(Class<T> nodeClass, String property, String value) {
        T node = null;
        try {
            node = neo4jTemplate.loadByProperty(nodeClass, property, value);
        } catch (Exception e) {
            logger.debug("element not found");
        }
        return node;
    }


}
