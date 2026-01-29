package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API controller for product operations.
 * Provides endpoints for CRUD operations and filtering products.
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    /**
     * Service for product operations.
     */
    private final IProductService productService;

    /**
     * Creates a new ProductController with the specified product service.
     *
     * @param productService the product service for data operations
     */
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @GetMapping("/products")
    public List<Product> index() {
        return this.productService.getProducts();
    }
}
