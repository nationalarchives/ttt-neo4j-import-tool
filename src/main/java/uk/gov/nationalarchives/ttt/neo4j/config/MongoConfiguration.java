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

    @Override
    public String getDatabaseName() {
        return "ttt";
    }


    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress("127.0.0.1", 27017)));
    }


    private static String personCollectionName = "WO_98_Discovery_A";

    public static String getPersonCollectionName() {
        return personCollectionName;
    }

    public static void setPersonCollectionName(String personCollectionName) {
        MongoConfiguration.personCollectionName = personCollectionName;
    }
}
