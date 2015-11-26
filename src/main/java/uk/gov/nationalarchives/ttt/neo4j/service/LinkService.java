package uk.gov.nationalarchives.ttt.neo4j.service;

import uk.gov.nationalarchives.ttt.neo4j.domain.Link;

/**
 * Created by jcharlet on 11/25/15.
 */
public interface LinkService {
    //    @Override
    void saveLink(Link link, String sourceFile);

    void bulkSaveLinksIntoGraphFromMongoCollection(String collectionName, Long limit, Double scoreThreshold);
}
