package com.example.dist_app.order.service;

import com.example.dist_app.order.model.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service implementation for order operations.
 * Creates and manages Order entities.
 */
@Service
public class OrderService implements IOrderService {
    /**
     * {@inheritDoc}
     */
    @Override
    public Order finalizeOrder(BigDecimal price, Long userId) {
        return new Order(price, userId);
    }
}
