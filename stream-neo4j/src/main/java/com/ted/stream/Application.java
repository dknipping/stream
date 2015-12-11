package com.ted.stream;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.GraphDatabaseAPI;
import org.neo4j.server.WrappingNeoServerBootstrapper;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.configuration.ServerConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ted.stream.repository.BookRepository;

@EnableWebMvc
@SpringBootApplication
@EnableNeo4jRepositories(basePackageClasses = BookRepository.class)
public class Application extends Neo4jConfiguration {

	public Application() {
		setBasePackage("com.ted.stream");
	}

	@SuppressWarnings("deprecation")
	@Bean
	public GraphDatabaseService graphDatabaseService() {
		GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabaseBuilder("stream.db").newGraphDatabase();
		GraphDatabaseAPI api = (GraphDatabaseAPI) db;
		ServerConfigurator config = new ServerConfigurator(api);
		config.configuration().addProperty(Configurator.WEBSERVER_PORT_PROPERTY_KEY, "7474");

		WrappingNeoServerBootstrapper bootstrapper = new WrappingNeoServerBootstrapper(api, config);
		bootstrapper.start();
		return db;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
