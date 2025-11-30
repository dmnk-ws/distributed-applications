package com.example.dist_app.cart.model;

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
     * Creates a new shopping cart with the specified id, user, and cart items.
     *
     * @param id        the unique identifier for this shopping cart
     * @param user      the user who owns this cart
     * @param cartItems the initial list of cart items, or null for an empty cart
     */
    public ShoppingCart(
        Long id,
        User user,
        List<CartItem> cartItems
    ) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems != null ? cartItems : new ArrayList<>();
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
}
