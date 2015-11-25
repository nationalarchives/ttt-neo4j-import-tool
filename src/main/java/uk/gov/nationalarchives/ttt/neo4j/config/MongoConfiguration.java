package uk.gov.nationalarchives.ttt.neo4j.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import static java.util.Collections.singletonList;

/**
 * Created by jcharlet on 14/11/15.
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 27017;
    public static final String DATABASE = "ttt";

    @Override
    public String getDatabaseName() {
        return DATABASE;
    }


    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress(HOST, PORT)));
    }

}
