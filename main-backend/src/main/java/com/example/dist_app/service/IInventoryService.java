package com.example.dist_app.service;

/**
 * Service interface for managing product inventory operations.
 */
public interface IInventoryService {
    /**
     * Retrieves the current stock quantity for a product.
     *
     * @param productId the ID of the product
     * @return the stock quantity, or 0 if the product is not found
     */
    Integer getStockForProductId(Long productId);

    /**
     * Reduces the stock quantity for a product by one unit.
     * If the stock is already zero or less, no action is taken.
     *
     * @param productId the ID of the product
     */
    void reduceStockForProductId(Long productId);
}