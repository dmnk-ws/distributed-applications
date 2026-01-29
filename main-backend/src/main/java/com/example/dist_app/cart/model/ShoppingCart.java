package com.example.dist_app.cart.model;

import com.example.dist_app.entity.enums.Currency;
import com.example.dist_app.products.model.Product;
import com.example.dist_app.user.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a shopping cart belonging to a user, containing a list of cart items.
 */
public class ShoppingCart {
    /**
     * The unique identifier for this shopping cart.
     */
    private Long id;

    /**
     * The user who owns this shopping cart.
     */
    private User user;

    /**
     * The list of items in this shopping cart.
     */
    private final List<CartItem> cartItems;

    /**
     * Indicates whether a discount is currently applied to this cart.
     */
    private Boolean isDiscounted;

    /**
     * The currency used for prices in this shopping cart.
     */
    private Currency currency;

    /**
     * Creates a new shopping cart with the specified attributes.
     *
     * @param id           the unique identifier for this shopping cart
     * @param user         the user who owns this cart
     * @param cartItems    the initial list of cart items, or null for an empty cart
     * @param isDiscounted whether a discount is applied to this cart
     * @param currency     the currency used for prices in this cart
     */
    public ShoppingCart(
        Long id,
        User user,
        List<CartItem> cartItems,
        Boolean isDiscounted,
        Currency currency
    ) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems != null ? cartItems : new ArrayList<>();
        this.isDiscounted = isDiscounted;
        this.currency = currency;
    }

    /**
     * Returns the unique identifier of this shopping cart.
     *
     * @return the shopping cart ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of this shopping cart.
     *
     * @param id the shopping cart ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the user who owns this shopping cart.
     *
     * @return the user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Sets the user who owns this shopping cart.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns the list of items in this shopping cart.
     *
     * @return the list of cart items
     */
    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    /**
     * Finds and returns a cart item by its associated product ID.
     *
     * @param id the product ID to search for
     * @return the cart item containing the product, or null if not found
     */
    public CartItem getCartItemByProductId(Long id) {
        return this.cartItems.stream()
            .filter(item -> Objects.equals(item.getProduct().getId(), id))
            .findFirst()
            .orElse(null);
    }

    /**
     * Adds an item to the shopping cart if it is not already present.
     *
     * @param item the cart item to add
     */
    public void addItem(CartItem item) {
        if (this.cartItems.contains(item)) {
            return;
        }

        this.cartItems.add(item);
    }

    /**
     * Calculates and returns the total price of all items in the cart.
     *
     * @return the total price in Euros
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem cartItem : this.cartItems) {
            total = total.add(cartItem.getSubTotal());
        }

        return total;
    }

    /**
     * Checks whether the cart contains a specific product.
     *
     * @param product the product to check for
     * @return true if the product is in the cart, false otherwise
     */
    public boolean hasProduct(Product product) {
        return this.cartItems.stream()
            .anyMatch(item -> Objects.equals(item.getProduct().getId(), product.getId()));
    }

    /**
     * Sets whether a discount is applied to this shopping cart.
     *
     * @param isDiscounted true to apply a discount, false to remove it
     */
    public void setIsDiscounted(Boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    /**
     * Checks whether this shopping cart has a discount applied.
     *
     * @return true if a discount is applied, false otherwise
     */
    public Boolean isDiscounted() {
        return this.isDiscounted;
    }

    /**
     * Sets the currency for this shopping cart.
     *
     * @param currency the currency to use for prices
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * Returns the currency used for prices in this shopping cart.
     *
     * @return the currency
     */
    public Currency getCurrency() {
        return this.currency;
    }
}
