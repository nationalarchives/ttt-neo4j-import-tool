package uk.gov.nationalarchives.ttt.neo4j.utils;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.gov.nationalarchives.ttt.neo4j.TestConfiguration;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.LinkRepository;
import uk.gov.nationalarchives.ttt.neo4j.dao.mongo.PersonDocumentRepository;
import uk.gov.nationalarchives.ttt.neo4j.service.LinkService;
import uk.gov.nationalarchives.ttt.neo4j.service.PersonGraphService;

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

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected void emptyNeo4jDatabase() {
        session.query("MATCH (n) DETACH DELETE n", new HashMap<String,Object>());
    }

    protected long generateNeo4jId(String name) {
        return Math.abs(new HashCodeBuilder().append(name).toHashCode());
    }

}
