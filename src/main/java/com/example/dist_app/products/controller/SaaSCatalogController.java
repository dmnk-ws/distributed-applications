package com.example.dist_app.products.controller;

import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API controller for product operations.
 * Provides software as a service for CRUD operations and filtering products.
 */
@RestController
@RequestMapping("/saas/catalog")
public class SaaSCatalogController {
    /**
     * Service for product operations.
     */
    private final IProductService productService;

    /**
     * Creates a new SaaSCatalogController with the specified product service.
     *
     * @param productService the product service for data operations
     */
    public SaaSCatalogController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @GetMapping("/")
    public List<Product> index() {
        return this.productService.getProducts();
    }
}
