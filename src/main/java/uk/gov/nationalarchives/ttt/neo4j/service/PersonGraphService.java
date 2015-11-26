package uk.gov.nationalarchives.ttt.neo4j.service;

import org.springframework.transaction.annotation.Transactional;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.Person;

/**
 * Created by jcharlet on 11/23/15.
 */
public interface PersonGraphService {
    @Transactional
    void savePersonGraph(Person person, String source);

    void bulkSavePeopleGraphFromMongoCollection(String personCollectionName, Integer limit);

    void emptyGraphDatabase();

//    void removePeopleFromCollection(String collectionName);
}
