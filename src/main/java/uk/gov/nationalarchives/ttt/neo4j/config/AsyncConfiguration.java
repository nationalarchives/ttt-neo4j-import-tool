package uk.gov.nationalarchives.ttt.neo4j.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jcharlet on 11/26/15.
 */
@Configuration
public class AsyncConfiguration {

    public static final int NB_THREADS = 4;

    @Bean
    public ExecutorService executorService(){
        return Executors.newFixedThreadPool(NB_THREADS);
    }
}
