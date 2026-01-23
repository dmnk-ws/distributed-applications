package com.example.dist_app.products.service;

import com.example.dist_app.products.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for managing product operations.
 */
public interface IProductService {
    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    List<Product> getProducts();

    /**
     * Adds a product to the repository.
     *
     * @param product the product to add
     */
    void add(Product product);

    /**
     * Creates a new product with the specified attributes and saves it.
     *
     * @param name  the name of the product
     * @param price the price of the product in Euros
     * @param size  the size of the product
     * @param color the color of the product
     * @return the created product
     */
    Product create(String name, BigDecimal price, Long size, String color);

    /**
     * Creates and saves a new product from an existing product object.
     *
     * @param product the product to create
     * @return the created product
     */
    Product create(Product product);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return the list of remaining products after deletion
     */
    List<Product> delete(Long id);

    /**
     * Updates an existing product with new values.
     *
     * @param id      the ID of the product to update
     * @param product the product containing updated values
     */
    void update(Long id, Product product);

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product, or null if not found
     */
    Product getProductById(Long id);

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
    List<Product> filter(Long id, String name, BigDecimal price, Long size, String color);

    /**
     * Retrieves all products with the color black.
     *
     * @return a list of black products
     */
    List<Product> getBlackProducts();

    /**
     * Retrieves all products with the color red.
     *
     * @return a list of red products
     */
    List<Product> getRedProducts();

    /**
     * Retrieves all products with the color blue.
     *
     * @return a list of blue products
     */
    List<Product> getBlueProducts();

    /**
     * Retrieves a paginated list of products.
     *
     * @param pageable the pagination information
     * @return a page of products
     */
    Page<Product> getPagedProducts(Pageable pageable);

    /**
     * Retrieves all products that suit the tenant configuration.
     *
     * @param tenantId the tenant id
     * @return a list of all products
     */
    List<Product> getTenantProducts(String tenantId);
}