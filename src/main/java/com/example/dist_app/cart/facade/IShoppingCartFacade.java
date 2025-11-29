package com.example.dist_app.cart.facade;

import com.example.dist_app.cart.model.ShoppingCart;

/**
 * Facade interface for shopping cart operations, providing a simplified API
 * for controllers to interact with the cart functionality.
 */
public interface IShoppingCartFacade {
    /**
     * Retrieves the current shopping cart.
     *
     * @return the shopping cart
     */
    ShoppingCart getShoppingCart();

    /**
     * Adds a product to the cart and returns a redirect URL.
     *
     * @param productId the ID of the product to add
     * @return a redirect URL string
     */
    String addToCart(Long productId);

    /**
     * Calculates and returns the total price of all items in the cart.
     *
     * @return the total price in Euros
     */
    Double getCartTotal();
}
