package com.example.dist_app.products.controller;

import com.example.dist_app.products.service.IProductService;
import com.example.dist_app.products.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * REST API controller for product operations.
 * Provides endpoints for CRUD operations and filtering products.
 */
@RestController
@RequestMapping("/rest/products")
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
    @GetMapping("/")
    public List<Product> index() {
        return this.productService.getProducts();
    }

    /**
     * Retrieves a single product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return the product with the specified ID
     */
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }

    /**
     * Filters products by the specified criteria. All parameters are optional.
     *
     * @param id    the product ID to filter by
     * @param name  the product name to filter by
     * @param price the product price to filter by
     * @param size  the product size to filter by
     * @param color the product color to filter by
     * @return a list of products matching the criteria
     */
    @GetMapping("/filtered")
    public List<Product> filter(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) BigDecimal price,
        @RequestParam(required = false) Long size,
        @RequestParam(required = false) String color
    ) {
        return this.productService.filter(id, name, price, size, color);
    }

    /**
     * Creates a new product with the specified attributes.
     *
     * @param name  the name of the product
     * @param price the price of the product in Euros
     * @param size  the size of the product
     * @param color the color of the product
     * @return a ResponseEntity containing the created product
     */
    @PostMapping("/create")
    public ResponseEntity<Product> create(
        @RequestParam String name,
        @RequestParam BigDecimal price,
        @RequestParam Long size,
        @RequestParam String color
    ) {
        Product product = this.productService.create(name, price, size, color);

        return ResponseEntity.ok(product);
    }

    /**
     * Creates a new product from a JSON request body.
     *
     * @param product the product to create
     * @return a ResponseEntity containing the created product
     */
    @PostMapping("/create-js")
    public ResponseEntity<Product> createJS(@RequestBody Product product) {
        Product createdProduct = this.productService.create(product);

        return ResponseEntity.ok(createdProduct);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return a ResponseEntity containing the list of remaining products
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable Long id) {
        List<Product> products = this.productService.delete(id);

        return ResponseEntity.ok(products);
    }

    /**
     * Updates an existing product with new values.
     *
     * @param id      the ID of the product to update
     * @param product the product containing updated values
     * @return a ResponseEntity containing the updated product
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(
        @PathVariable Long id,
        @RequestBody Product product
    ) {
        this.productService.update(id, product);

        return ResponseEntity.ok(
            this.productService.getProductById(id)
        );
    }
}
