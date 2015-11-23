package uk.gov.nationalarchives.ttt.neo4j.dao.mongo.impl;

import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.PersonDocumentRepositoryCustom;

/**
 * Created by jcharlet on 11/23/15.
 */
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
