package com.example.dist_app.order.service;

import com.example.dist_app.order.model.Order;

import java.math.BigDecimal;

/**
 * Adapter interface for order operations.
 * Provides a simplified API for order processing and related side effects.
 */
public interface IOrderAdapter {
    /**
     * Finalizes an order with the specified price.
     *
     * @param price the total price of the order
     * @return the finalized order
     */
    Order finalizeOrder(BigDecimal price);
}
