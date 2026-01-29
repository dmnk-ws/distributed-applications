package com.example.dist_app.order.service;

// import com.example.dist_app.user.service.IUserService;
import com.example.dist_app.order.model.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service implementation for order operations.
 * Creates and manages Order entities.
 */
@Service
public class OrderService implements IOrderService {
    // private final IUserService userService;

    // public OrderService(IUserService userService) {
    //     this.userService = userService;
    // }

    /**
     * Default constructor.
     */
    public OrderService() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order finalizeOrder(BigDecimal price, Long userId) {
        return new Order(price, userId);
    }

    // public Order finalizeOrderWithTotal(BigDecimal total) {
    //     Long userId = this.userService.getUserId();
    //     return new Order(total, userId);
    // }

    // public Order getRecentOrderForUser(Long userId) {
    //     return new Order(BigDecimal.ZERO, userId);
    // }
}
