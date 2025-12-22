package com.example.dist_app.order.service;

import com.example.dist_app.order.facade.IOrderFacade;
import com.example.dist_app.order.model.Order;
import com.example.dist_app.service.IEmailService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service implementation of the order adapter.
 * Coordinates order finalization with email notification.
 */
@Service
public class OrderAdapter implements IOrderAdapter {
    /**
     * Facade for core order operations.
     */
    private final IOrderFacade orderFacade;

    /**
     * Service for sending email notifications.
     */
    private final IEmailService emailService;

    /**
     * Constructs an OrderAdapter with the required dependencies.
     *
     * @param orderFacade facade for core order operations
     * @param emailService service for sending email notifications
     */
    public OrderAdapter(IOrderFacade orderFacade, IEmailService emailService) {
        this.orderFacade = orderFacade;
        this.emailService = emailService;
    }

    /**
     * Finalizes an order and sends a confirmation email to the user.
     *
     * @param price the total price of the order
     * @return the finalized order
     */
    public Order finalizeOrder(BigDecimal price) {
        Order order = this.orderFacade.finalizeOrder(price);
        this.emailService.sendEMail(order.getUserId());

        return order;
    }
}
