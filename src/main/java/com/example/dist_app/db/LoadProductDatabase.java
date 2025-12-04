package com.example.dist_app.db;

import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * Configuration class for initializing the product database with sample data.
 * Loads initial product records when the application starts.
 */
@Configuration
public class LoadProductDatabase {

    /**
     * Default constructor for LoadProductDatabase.
     */
    public LoadProductDatabase() {
    }

    /**
     * Logger for this class.
     */
    private static final Logger log = LoggerFactory.getLogger(LoadProductDatabase.class);

    /**
     * Creates a CommandLineRunner that preloads sample products into the database.
     * If the database already contains more than 20 products, no data is loaded.
     *
     * @param repository the product repository for data access
     * @return a CommandLineRunner that initializes the database
     */
    @Bean
    CommandLineRunner init(ProductRepository repository) {
        if (repository.count() > 20) {
            return args -> {};
        }

        return args -> {
            log.info("Preloading " + repository.save(new Product("Lightsaber", new BigDecimal("999.99"), 1L, "blue")));
            log.info("Preloading " + repository.save(new Product("Lightsaber", new BigDecimal("1999.99"), 1L, "red")));
            log.info("Preloading " + repository.save(new Product("Millennium Falcon", new BigDecimal("399.99"), 1L, "grey")));
            log.info("Preloading " + repository.save(new Product("Stormtrooper Helmet", new BigDecimal("199.99"), 1L, "white")));
            log.info("Preloading " + repository.save(new Product("Blaster", new BigDecimal("599.99"), 1L, "black")));
            log.info("Preloading " + repository.save(new Product("Jedi Book", new BigDecimal("99.99"), 1L, "brown")));
        };
    }
}
