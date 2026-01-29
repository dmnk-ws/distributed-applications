package com.example.dist_app.products.service;

import com.example.dist_app.products.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Service implementation for fetching products from an external microservice.
 * Uses RestTemplate to make HTTP requests to the configured product backend
 * and deserializes the response into Product entities.
 */
@Service
public class ExternalProductService implements IExternalProductService {

    /**
     * The URL of the external product backend service.
     * Configured via the {@code product.backend} property in application.properties.
     */
    @Value("${product.backend}")
    private String url;

    /**
     * REST client for making HTTP requests to external services.
     */
    private final RestTemplate restTemplate;

    /**
     * Creates a new ExternalProductService with the specified RestTemplate.
     *
     * @param restTemplate the REST client for making HTTP requests
     */
    public ExternalProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> fetchProducts() {
        Product[] products = restTemplate.getForObject(this.url, Product[].class);

        return products != null ? Arrays.asList(products) : List.of();
    }
}
