package com.example.dist_app.order.facade;

import com.example.dist_app.order.model.Order;

import java.math.BigDecimal;

/**
 * Facade interface for order operations.
 * Provides a simplified interface for finalizing orders.
 */
public interface IOrderFacade {
    /**
     * Finalizes an order with the specified price.
     * The user ID is automatically retrieved from the current user context.
     *
     * @param price the total price of the order
     * @return the finalized order
     */
    Order finalizeOrder(BigDecimal price);
}
