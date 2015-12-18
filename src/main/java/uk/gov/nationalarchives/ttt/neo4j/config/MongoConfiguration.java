package uk.gov.nationalarchives.ttt.neo4j.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import static java.util.Collections.singletonList;

/**
 * Created by jcharlet on 14/11/15.
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Autowired
    MongoProperties mongoProperties;

    @Override
    public String getDatabaseName() {
        return mongoProperties.getDatabase();
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort())));
    }

}
