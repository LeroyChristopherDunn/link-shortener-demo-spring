package org.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

// https://spring.io/guides/gs/accessing-data-rest/
// https://www.baeldung.com/spring-rest-openapi-documentation
// https://springdoc.org/
@SpringBootApplication
public class SpringRestRepoDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringRestRepoDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringRestRepoDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner swaggerInfo() {
		return args -> {
			log.info("Open API docs: http://localhost:8080/v3/api-docs/ " );
			log.info("Swagger UI: http://localhost:8080/swagger-ui.html ");
		};
	}

	@Bean
	CommandLineRunner initDatabaseWithPeople(PersonRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Person( "Bilbo", "Baggins")));
			log.info("Preloading " + repository.save(new Person("Frodo", "Baggins")));
		};
	}

	@Bean
	CommandLineRunner initDatabaseWithLinks(LinkRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Link("1", "https://www.google.com/search?q=1")));
			log.info("Preloading " + repository.save(new Link("2", "https://www.google.com/search?q=2")));
			log.info("Preloading " + repository.save(new Link("3", "https://www.google.com/search?q=3")));
			log.info("Preloading " + repository.save(new Link("4", "https://www.google.com/search?q=4")));
			log.info("Preloading " + repository.save(new Link("5", "https://www.google.com/search?q=5")));
		};
	}

	@Bean
	public RepositoryRestConfigurer personRepositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(Person.class));
	}

	@Bean
	public RepositoryRestConfigurer linkRepositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(Link.class));
	}
}
