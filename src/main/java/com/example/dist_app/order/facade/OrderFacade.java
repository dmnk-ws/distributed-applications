package com.example.dist_app.order.facade;

import com.example.dist_app.order.model.Order;
import com.example.dist_app.order.service.IOrderService;
import com.example.dist_app.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Facade implementation for order operations.
 * Coordinates between user and order services to finalize orders.
 */
@Service
public class OrderFacade implements IOrderFacade {
    /**
     * Service for retrieving user information.
     */
    private final IUserService userService;

    /**
     * Service for order operations.
     */
    private final IOrderService orderService;

    /**
     * Constructs an OrderFacade with the required services.
     *
     * @param userService  the service for retrieving user information
     * @param orderService the service for order operations
     */
    public OrderFacade(IUserService userService, IOrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order finalizeOrder(BigDecimal price) {
        Long userId = this.userService.getUserId();

        return this.orderService.finalizeOrder(price, userId);
    }
}
