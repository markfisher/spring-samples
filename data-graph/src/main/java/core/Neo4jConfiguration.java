package core;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.graph.neo4j.config.AbstractNeo4jConfiguration;

@Configuration
public class Neo4jConfiguration extends AbstractNeo4jConfiguration {

	@Override
	public boolean isUsingCrossStorePersistence() {
		return false;
	}

	@Override
	public GraphDatabaseService graphDatabaseService() {
		return new EmbeddedGraphDatabase("target/neo4j-db");
	}

}
