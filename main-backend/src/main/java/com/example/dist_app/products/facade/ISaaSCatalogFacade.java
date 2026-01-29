package com.example.dist_app.products.facade;

import com.example.dist_app.products.model.Product;

import java.util.List;

/**
 * Facade interface for SaaS catalog operations.
 * Provides a unified interface for accessing product data from multiple sources,
 * abstracting the complexity of combining internal and external product services.
 */
public interface ISaaSCatalogFacade {

    /**
     * Retrieves all products available to a specific tenant.
     * Combines products from both internal storage and external services.
     *
     * @param tenantId the unique identifier of the tenant requesting products
     * @return a list of all products available to the tenant
     */
    List<Product> getProducts(String tenantId);
}
