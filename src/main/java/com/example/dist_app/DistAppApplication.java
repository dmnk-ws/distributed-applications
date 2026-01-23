package com.example.dist_app;

import com.example.dist_app.config.TenantConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Main Spring Boot application class for the distributed applications project.
 * This is the entry point of the application.
 */
@SpringBootApplication
@EnableConfigurationProperties(TenantConfig.class)
public class DistAppApplication {

	/**
	 * Default constructor for DistAppApplication.
	 */
	public DistAppApplication() {
	}

	/**
	 * Main method that starts the Spring Boot application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DistAppApplication.class, args);
	}

}
