package uk.gov.nationalarchives.ttt.neo4j.dao.mongo.impl;

import org.springframework.stereotype.Repository;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.LinkRepositoryCustom;

/**
 * Created by jcharlet on 11/23/15.
 */
@Repository
public class LinkRepositoryImpl implements LinkRepositoryCustom {

    private static String collectionName = "";

    @Override
    public String getCollectionName() {
        return collectionName;
    }

    @Override
    public void setCollectionName(String collectionName) {
        LinkRepositoryImpl.collectionName = collectionName;
    }
}
