package uk.gov.nationalarchives.ttt.neo4j.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.gov.nationalarchives.ttt.neo4j.TestConfiguration;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.LinkRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.PersonDocumentRepository;
import uk.gov.nationalarchives.ttt.neo4j.service.LinkService;
import uk.gov.nationalarchives.ttt.neo4j.service.PersonGraphService;

import java.io.File;
import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfiguration.class)
//@WebAppConfiguration
public abstract class BaseTestClass {
    @Autowired
    protected Session session;

    @Autowired
    protected PersonGraphService personGraphService;

    @Autowired
    protected LinkService linkService;

    @Autowired
    protected PersonDocumentRepository personDocumentRepository;

    @Autowired
    protected LinkRepository linkRepository;

    @Autowired
    protected MongoTemplate mongoTemplate;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected void emptyNeo4jDatabase() {
        session.query("MATCH (n) DETACH DELETE n", new HashMap<String,Object>());
    }

    protected long generateNeo4jId(String name) {
        return Math.abs(new HashCodeBuilder().append(name).toHashCode());
    }

    protected void importMongoCollectionIfMissing(String personCollectionName, String inputFilePath) {
        if(!mongoTemplate.collectionExists(personCollectionName)){
            try {
                JsonFactory f = new MappingJsonFactory();
                JsonParser jp = f.createJsonParser(getClass().getResourceAsStream(inputFilePath));
                @SuppressWarnings("unused")
                JsonToken current = null;
                current = jp.nextToken();
                JsonNode arrayOfDocuments = jp.readValueAsTree();
                arrayOfDocuments.elements().forEachRemaining(
                        document -> mongoTemplate.insert(document.toString(),personCollectionName)
                );
                current = null;
            } catch (Exception e) {
                logger.error("the parsing of the json file failed");
                throw new RuntimeException(e);
            }
        }
    }

    public void parse(String inputFileCollection, File args) {


    }

}
