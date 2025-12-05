package com.example.dist_app.cart.facade;

import com.example.dist_app.cart.model.ShoppingCart;
import com.example.dist_app.cart.service.IShoppingCartService;
import com.example.dist_app.entity.enums.Currency;
import com.example.dist_app.service.IInventoryService;
import com.example.dist_app.service.IPriceCalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Facade service that coordinates shopping cart operations with inventory management.
 * This class provides a simplified interface for cart operations by combining
 * the shopping cart service and inventory service functionalities.
 *
 * <p><b>Dependencies (injected via constructor):</b></p>
 * <ul>
 *   <li>{@link IInventoryService} - Provides stock level queries and stock reduction operations</li>
 *   <li>{@link IShoppingCartService} - Manages the shopping cart state and cart item operations</li>
 * </ul>
 *
 * @see IShoppingCartFacade
 * @see IInventoryService
 * @see IShoppingCartService
 */
@Service
public class ShoppingCartFacade implements IShoppingCartFacade {

    /**
     * Service for managing product inventory and stock levels.
     * Used to check stock availability before adding items to cart.
     */
    private final IInventoryService inventoryService;

    /**
     * Service for managing the shopping cart state and operations.
     * Handles adding items, retrieving cart contents, and calculating totals.
     */
    private final IShoppingCartService shoppingCartService;

    /**
     * Service for calculating prices, discounts, and currency conversions.
     * Used to apply discounts to cart items.
     */
    private final IPriceCalculationService priceCalculationService;

    /**
     * Constructs a ShoppingCartFacade with the required service dependencies.
     *
     * @param inventoryService the inventory service for stock management
     * @param cartService the shopping cart service for cart operations
     * @param priceCalculationService the price calculation service for discount operations
     */
    public ShoppingCartFacade(
        IInventoryService inventoryService,
        IShoppingCartService cartService,
        IPriceCalculationService priceCalculationService
    ) {
        this.inventoryService = inventoryService;
        this.shoppingCartService = cartService;
        this.priceCalculationService = priceCalculationService;
    }

    /**
     * Retrieves the current shopping cart with all its items.
     * Delegates to the shopping cart service to fetch the cart state.
     *
     * @return the current {@link ShoppingCart} containing all cart items
     */
    public ShoppingCart getShoppingCart() {
        return this.shoppingCartService.getShoppingCart();
    }

    /**
     * Adds a product to the shopping cart if sufficient stock is available.
     * This method coordinates between inventory and cart services: it first checks
     * stock availability, then reduces the stock count, and finally adds the item to the cart.
     *
     * @param productId the unique identifier of the product to add to the cart
     * @return a redirect URL string to the cart view page; returns the same redirect
     *         regardless of whether the item was added (stock available) or not (out of stock)
     */
    public String addToCart(Long productId) {
        if (this.inventoryService.getStockForProductId(productId) < 1) {
            return "redirect:/mvc/cart";
        }

        this.inventoryService.reduceStockForProductId(productId);
        this.shoppingCartService.addCartItemByProductId(productId);

        return "redirect:/mvc/cart";
    }

    /**
     * Calculates and returns the total price of all items in the shopping cart.
     * The total is computed by summing up the prices of all cart items.
     *
     * @return the total price of the cart as a BigDecimal value
     */
    public BigDecimal getCartTotal() {
        return this.shoppingCartService.getCartTotal();
    }

    /**
     * Applies or removes a discount voucher and calculates the final price.
     *
     * @param amount the original price amount
     * @param percentage the discount percentage to apply
     * @param voucher true to apply the discount, false to remove it
     * @return the discounted price if voucher is true, otherwise the original amount
     */
    public BigDecimal getDiscountedPrice(BigDecimal amount, BigDecimal percentage, Boolean voucher) {
        ShoppingCart cart = this.shoppingCartService.getShoppingCart();
        cart.setIsDiscounted(voucher);

        return voucher
            ? this.priceCalculationService.discount(amount, percentage)
            : amount;
    }

    /**
     * Converts an amount from the default currency to the target currency
     * and updates the cart's currency.
     *
     * @param amount the amount to convert (in the default currency)
     * @param to the target currency
     * @return the converted amount in the target currency
     */
    public BigDecimal convert(BigDecimal amount, Currency to) {
        this.shoppingCartService.getShoppingCart().setCurrency(to);

        return this.priceCalculationService.convert(
            amount,
            this.priceCalculationService.getDefaultCurrency(),
            to
        );
    }
}
