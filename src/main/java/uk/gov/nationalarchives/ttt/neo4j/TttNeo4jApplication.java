package uk.gov.nationalarchives.ttt.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TttNeo4jApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TttNeo4jApplication.class, args);
        SpringApplication.exit(applicationContext);
    }
}
