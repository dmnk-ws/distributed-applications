package com.example.dist_app.cart.service;

import com.example.dist_app.cart.model.ShoppingCart;

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
    Double getCartTotal();
}
