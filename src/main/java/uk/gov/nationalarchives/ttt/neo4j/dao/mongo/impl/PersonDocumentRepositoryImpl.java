package uk.gov.nationalarchives.ttt.neo4j.dao.mongo.impl;

import org.springframework.stereotype.Repository;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.PersonDocumentRepositoryCustom;

/**
 * Created by jcharlet on 11/23/15.
 */
@Repository
public class PersonDocumentRepositoryImpl implements PersonDocumentRepositoryCustom {

    private static String personCollectionName = "Person";

    @Override
    public String getPersonCollectionName() {
        return personCollectionName;
    }

    @Override
    public void setPersonCollectionName(String personCollectionName) {
        PersonDocumentRepositoryImpl.personCollectionName = personCollectionName;
    }
}
