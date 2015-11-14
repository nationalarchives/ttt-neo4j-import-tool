package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson;

import org.neo4j.ogm.annotation.GraphId;

/**
 * Created by jcharlet on 14/11/15.
 */
public abstract class Neo4jObject {
    @GraphId
    Long neo4jId;
}
