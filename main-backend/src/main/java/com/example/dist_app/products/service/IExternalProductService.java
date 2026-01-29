package com.example.dist_app.products.service;

import com.example.dist_app.products.model.Product;

import java.util.List;

/**
 * Service interface for fetching products from external sources.
 * Defines the contract for communicating with external product microservices
 * in the distributed system architecture.
 */
public interface IExternalProductService {

    /**
     * Fetches all products from the external product service.
     * Makes an HTTP request to the configured external backend to retrieve
     * product data.
     *
     * @return a list of products from the external service, or an empty list if unavailable
     */
    List<Product> fetchProducts();
}
