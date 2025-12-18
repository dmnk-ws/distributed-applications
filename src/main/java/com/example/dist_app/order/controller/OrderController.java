package com.example.dist_app.order.controller;

import com.example.dist_app.order.facade.IOrderFacade;
import com.example.dist_app.order.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Spring MVC controller for handling order-related requests.
 * Manages the checkout process and order finalization.
 */
@Controller
@RequestMapping("/mvc/order")
public class OrderController {
    /**
     * Facade for order operations.
     */
    private final IOrderFacade orderFacade;

    /**
     * Constructs an OrderController with the required order facade.
     *
     * @param orderFacade the facade for order operations
     */
    public OrderController(IOrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    /**
     * Handles the checkout process by finalizing an order with the specified price.
     *
     * @param price the total price of the order
     * @param model the Spring MVC model for passing data to the view
     * @return the name of the checkout view template
     */
    @PostMapping("/checkout")
    public String checkout(
        @RequestParam BigDecimal price,
        Model model
    ) {
        Order order = this.orderFacade.finalizeOrder(price);

        model.addAttribute("price", order.getPrice());
        model.addAttribute("userId", order.getUserId());

        return "order/checkout";
    }
}
