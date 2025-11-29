package com.example.dist_app.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service implementation for managing product inventory operations.
 * Maintains an in-memory inventory of product stock quantities.
 */
@Service
public class InventoryService implements IInventoryService {

    /**
     * In-memory map of product IDs to their stock quantities.
     */
    private final Map<Long, Integer> inventory = new HashMap<>(
        Map.of(
            1L, 2,
            2L, 5,
            3L, 15,
            4L, 20,
            5L, 30
        )
    );

    /**
     * Retrieves the current stock quantity for a product.
     *
     * @param productId the ID of the product
     * @return the stock quantity, or 0 if the product is not found
     */
    public Integer getStockForProductId(Long productId) {
        return inventory.getOrDefault(productId, 0);
    }

    /**
     * Reduces the stock quantity for a product by one unit.
     * If the stock is already zero or less, no action is taken.
     *
     * @param productId the ID of the product
     */
    public void reduceStockForProductId(Long productId) {
        Integer currentStock = inventory.getOrDefault(productId, 0);

        if (currentStock < 1) {
            return;
        }

        inventory.put(productId, currentStock - 1);
    }
}