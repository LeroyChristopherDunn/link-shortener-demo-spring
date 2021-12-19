package org.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class LinkRepositoryConfig {

    private static final Logger log = LoggerFactory.getLogger(LinkRepositoryConfig.class);

    @Bean
    public RepositoryRestConfigurer linkRepositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(Link.class));
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
}
