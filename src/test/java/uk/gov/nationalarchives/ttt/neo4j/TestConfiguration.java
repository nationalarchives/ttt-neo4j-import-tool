package uk.gov.nationalarchives.ttt.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import uk.gov.nationalarchives.ttt.neo4j.cli.TTTNeo4jCommandLineInterface;
import uk.gov.nationalarchives.ttt.neo4j.config.MongoConfiguration;
import uk.gov.nationalarchives.ttt.neo4j.config.TTTNeo4jConfiguration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "uk.gov.nationalarchives.ttt.neo4j" },
        excludeFilters ={ @ComponentScan.Filter(type =FilterType.ASSIGNABLE_TYPE, value=TTTNeo4jCommandLineInterface
                .class),@ComponentScan.Filter(type =FilterType.ASSIGNABLE_TYPE, value=TttNeo4jApplication
                .class)})
@Import({TTTNeo4jConfiguration.class, MongoConfiguration.class})
public class TestConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(TestConfiguration.class, args);
    }
}
