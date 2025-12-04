package com.example.dist_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for the distributed applications project.
 * This is the entry point of the application.
 */
@SpringBootApplication
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
