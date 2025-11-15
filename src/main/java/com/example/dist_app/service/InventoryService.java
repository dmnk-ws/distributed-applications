package com.example.dist_app.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService implements IInventoryService {

    private final Map<Long, Integer> inventory = new HashMap<>(
        Map.of(
            1L, 2,
            2L, 5,
            3L, 15,
            4L, 20,
            5L, 30
        )
    );

    public Integer getStockForProductId(Long productId) {
        return inventory.getOrDefault(productId, 0);
    }

    public void reduceStockForProductId(Long productId) {
        Integer currentStock = inventory.getOrDefault(productId, 0);

        if (currentStock < 1) {
            return;
        }

        inventory.put(productId, currentStock - 1);
    }
}