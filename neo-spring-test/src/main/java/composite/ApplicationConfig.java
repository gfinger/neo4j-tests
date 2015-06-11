package composite;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@EnableNeo4jRepositories(basePackages = "composite")
@EnableAutoConfiguration
public class ApplicationConfig extends Neo4jConfiguration {
	private static final String DATABASE_PATH = "target/cmmn.db";

	public ApplicationConfig() {
		setBasePackage("composite");
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {
		GraphDatabaseService db = new GraphDatabaseFactory()
				.newEmbeddedDatabase(DATABASE_PATH);
		return db;
	}
}