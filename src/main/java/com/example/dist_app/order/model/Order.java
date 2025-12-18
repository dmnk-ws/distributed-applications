package com.example.dist_app.order.model;

import java.math.BigDecimal;

/**
 * Represents an immutable order entity containing price and user information.
 */
public class Order {
    /**
     * The total price of the order.
     */
    private final BigDecimal price;

    /**
     * The ID of the user who placed the order.
     */
    private final Long userId;

    /**
     * Constructs a new Order with the specified price and user ID.
     *
     * @param price  the total price of the order
     * @param userId the ID of the user placing the order
     */
    public Order(BigDecimal price, Long userId) {
        this.price = price;
        this.userId = userId;
    }

    /**
     * Returns the total price of the order.
     *
     * @return the order price
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Returns the ID of the user who placed the order.
     *
     * @return the user ID
     */
    public Long getUserId() {
        return this.userId;
    }
}
