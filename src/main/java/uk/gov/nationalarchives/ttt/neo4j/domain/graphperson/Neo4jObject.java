package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson;

import org.neo4j.ogm.annotation.GraphId;

/**
 * Created by jcharlet on 14/11/15.
 */
public abstract class Neo4jObject {
    @GraphId
    Long neo4jId;

    public Long getNeo4jId() {
        return neo4jId;
    }

    public void setNeo4jId(Long neo4jId) {
        this.neo4jId = neo4jId;
    }
}
