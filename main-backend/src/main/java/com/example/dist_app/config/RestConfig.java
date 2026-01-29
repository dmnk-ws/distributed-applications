package com.example.dist_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for REST-related beans.
 * Provides HTTP client components for making outbound REST API calls
 * to external services.
 */
@Configuration
public class RestConfig {

    /**
     * Creates a RestTemplate bean for making HTTP requests to external services.
     * This template is used for server-to-server communication with other
     * microservices in the distributed system.
     *
     * @return a configured RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}