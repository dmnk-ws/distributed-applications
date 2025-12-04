package com.example.dist_app.cart.service;

import com.example.dist_app.cart.model.ShoppingCart;

import java.math.BigDecimal;

/**
 * Service interface for managing shopping cart operations.
 */
public interface IShoppingCartService {
    /**
     * Retrieves the current shopping cart.
     *
     * @return the shopping cart
     */
    ShoppingCart getShoppingCart();

    /**
     * Adds a product to the cart by its ID. If the product already exists in the cart,
     * its quantity is incremented.
     *
     * @param id the ID of the product to add
     */
    void addCartItemByProductId(Long id);

    /**
     * Calculates and returns the total price of all items in the cart.
     *
     * @return the total price in Euros
     */
    BigDecimal getCartTotal();

    /**
     * Sets the discount state of the shopping cart.
     *
     * @param isDiscounted true to apply a discount, false to remove it
     */
    void discount(Boolean isDiscounted);

    /**
     * Checks whether the shopping cart currently has a discount applied.
     *
     * @return true if a discount is applied, false otherwise
     */
    Boolean isDiscounted();
}
