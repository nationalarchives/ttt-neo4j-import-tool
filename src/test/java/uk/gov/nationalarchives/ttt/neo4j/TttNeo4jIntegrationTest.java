package uk.gov.nationalarchives.ttt.neo4j;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TttNeo4jApplication.class)
//@IntegrationTest({"ttt.mongodb.database=ttt"})
public class TttNeo4jIntegrationTest {


    @Test
    public void testRunningCli() {
        Assert.assertTrue(true); //must not raise exception
    }

}
