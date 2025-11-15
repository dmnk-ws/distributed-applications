package com.example.dist_app.service;

public interface IInventoryService {
    Integer getStockForProductId(Long productId);
    void reduceStockForProductId(Long productId);
}