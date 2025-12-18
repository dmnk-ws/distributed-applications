package com.example.dist_app.order.service;

import com.example.dist_app.order.model.Order;

import java.math.BigDecimal;

/**
 * Service interface for order operations.
 */
public interface IOrderService {
    /**
     * Finalizes an order with the specified price and user ID.
     *
     * @param price  the total price of the order
     * @param userId the ID of the user placing the order
     * @return the finalized order
     */
    Order finalizeOrder(BigDecimal price, Long userId);
}
