package com.example.dist_app.cart.facade;

import com.example.dist_app.cart.model.ShoppingCart;
import com.example.dist_app.entity.enums.Currency;

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
     * Applies or removes a discount voucher and calculates the final price.
     *
     * @param amount the original price amount
     * @param percentage the discount percentage to apply
     * @param voucher true to apply the discount, false to remove it
     * @return the discounted price if voucher is true, otherwise the original amount
     */
    BigDecimal getDiscountedPrice(BigDecimal amount, BigDecimal percentage, Boolean voucher);

    /**
     * Converts an amount from the default currency to the target currency
     * and updates the cart's currency.
     *
     * @param amount the amount to convert (in the default currency)
     * @param to the target currency
     * @return the converted amount in the target currency
     */
    BigDecimal convert(BigDecimal amount, Currency to);
}
