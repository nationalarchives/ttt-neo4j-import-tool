package uk.gov.nationalarchives.ttt.neo4j.dao.mongo;

/**
 * Created by jcharlet on 11/23/15.
 */
public interface PersonDocumentRepositoryCustom {
    String getPersonCollectionName();

    void setPersonCollectionName(String personCollectionName);
}
