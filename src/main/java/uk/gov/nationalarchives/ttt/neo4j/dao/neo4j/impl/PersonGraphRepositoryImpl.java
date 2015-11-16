package uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.impl;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import uk.gov.nationalarchives.ttt.neo4j.dao.neo4j.CustomPersonGraphRepository;
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

        neo4jPerson=neo4jTemplate.save(neo4jPerson,0);
        for (HasFamilyName hasFamilyName : neo4jPerson.getHasFamilyNames()) {
            FamilyName familyName = hasFamilyName.getFamilyName();
            FamilyName retrievedFamilyName = null;
            try {
                retrievedFamilyName = neo4jTemplate.loadByProperty(FamilyName.class, "name", familyName.getName());
            } catch (Exception e) {
                logger.debug("element not found");
            }
            if (retrievedFamilyName==null){
                familyName=neo4jTemplate.save(familyName, 0);
            }else{
                familyName=retrievedFamilyName;
            }
            hasFamilyName.setFamilyName(familyName);
            hasFamilyName.setPerson(neo4jPerson);
        }
        neo4jPerson=neo4jTemplate.save(neo4jPerson,1);
        return neo4jPerson;
    }

}
