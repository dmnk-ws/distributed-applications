package com.example.dist_app.products.facade;

import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.service.IExternalProductService;
import com.example.dist_app.products.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade implementation for SaaS catalog operations.
 * Aggregates product data from multiple sources including the internal
 * product service and external microservices, providing a unified view
 * of the product catalog for each tenant.
 */
@Service
public class SaaSCatalogFacade implements ISaaSCatalogFacade {

    /**
     * Service for accessing internal tenant-specific products.
     */
    private final IProductService productService;

    /**
     * Service for fetching products from external microservices.
     */
    private final IExternalProductService externalProductService;

    /**
     * Creates a new SaaSCatalogFacade with the required services.
     *
     * @param productService the internal product service for tenant-specific products
     * @param externalProductService the service for fetching external products
     */
    public SaaSCatalogFacade(IProductService productService, IExternalProductService externalProductService) {
        this.productService = productService;
        this.externalProductService = externalProductService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> getProducts(String tenantId) {
        List<Product> tenantProducts = this.productService.getTenantProducts(tenantId);
        List<Product> externalProducts = this.externalProductService.fetchProducts();

        List<Product> combined = new ArrayList<>(tenantProducts);
        combined.addAll(externalProducts);

        return combined;
    }
}
