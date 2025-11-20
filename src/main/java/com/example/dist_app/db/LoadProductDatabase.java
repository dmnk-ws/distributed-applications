package com.example.dist_app.db;

import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadProductDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadProductDatabase.class);

    @Bean
    CommandLineRunner init(ProductRepository repository) {
        if (repository.count() > 20) {
            return args -> {};
        }

        return args -> {
            log.info("Preloading " + repository.save(new Product("Lightsaber", 999.99, 1L, "blue")));
            log.info("Preloading " + repository.save(new Product("Lightsaber", 1999.99, 1L, "red")));
            log.info("Preloading " + repository.save(new Product("Millennium Falcon", 399.99, 1L, "grey")));
            log.info("Preloading " + repository.save(new Product("Stormtrooper Helmet", 199.99, 1L, "white")));
            log.info("Preloading " + repository.save(new Product("Blaster", 599.99, 1L, "black")));
            log.info("Preloading " + repository.save(new Product("Jedi Book", 99.99, 1L, "brown")));
        };
    }
}
