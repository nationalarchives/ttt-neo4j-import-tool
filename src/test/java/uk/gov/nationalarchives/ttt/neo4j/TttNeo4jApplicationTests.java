package uk.gov.nationalarchives.ttt.neo4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TttNeo4jApplication.class)
@WebAppConfiguration
public class TttNeo4jApplicationTests {

	@Test
	public void contextLoads() {
	}

}
