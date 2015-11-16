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
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.HasFamilyName;

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
            FamilyName familyName = getOrCreateFamilyName(hasFamilyName);
            hasFamilyName.setFamilyName(familyName);
            hasFamilyName.setPerson(neo4jPerson);
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

    private FamilyName getOrCreateFamilyName(HasFamilyName hasFamilyName) {
        FamilyName familyName;
        final FamilyName initialFamilyName = hasFamilyName.getFamilyName();

        final String name = initialFamilyName.getName();
        FamilyName retrievedFamilyName = findFamilyNameNodeByName(name);

        if (retrievedFamilyName==null){
            familyName=neo4jTemplate.save(initialFamilyName, 0);
        }else{
            familyName=retrievedFamilyName;
        }
        return familyName;
    }

    private FamilyName findFamilyNameNodeByName(String familyNameName) {
        FamilyName retrievedFamilyName = null;
        try {
            retrievedFamilyName = neo4jTemplate.loadByProperty(FamilyName.class, "name", familyNameName);
        } catch (Exception e) {
            logger.debug("element not found");
        }
        return retrievedFamilyName;
    }

}
