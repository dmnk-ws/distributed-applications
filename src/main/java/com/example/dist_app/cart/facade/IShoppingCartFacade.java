package com.example.dist_app.cart.facade;

import com.example.dist_app.cart.model.ShoppingCart;

import java.math.BigDecimal;

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
     * Calculates and returns the total price of all items in the shopping cart.
     * The total is computed by summing up the prices of all cart items.
     *
     * @return the total price of the cart as a BigDecimal value
     */
    BigDecimal getCartTotal();

    /**
     * Calculates the discounted price based on the given amount and percentage.
     *
     * @param amount the original price amount
     * @param percentage the discount percentage to apply
     * @return the discounted price as a BigDecimal value
     */
    BigDecimal getDiscountedPrice(BigDecimal amount, BigDecimal percentage);

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
