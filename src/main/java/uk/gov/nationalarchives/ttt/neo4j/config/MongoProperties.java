package uk.gov.nationalarchives.ttt.neo4j.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jcharlet on 12/17/15.
 */
@Component
@ConfigurationProperties(prefix="ttt.mongodb")
public class MongoProperties {
    private String host;
    private Integer port;
    private String database;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
