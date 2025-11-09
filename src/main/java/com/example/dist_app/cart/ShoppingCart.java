package com.example.dist_app.cart;

import com.example.dist_app.products.Product;
import com.example.dist_app.user.User;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Long id;
    private User user;
    private final List<CartItem> cartItems;

    public ShoppingCart(
        Long id,
        User user,
        List<CartItem> cartItems
    ) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems != null ? cartItems : new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public CartItem getCartItemByProductId(Long id) {
        return this.cartItems.stream()
            .filter(item -> item.getProduct().getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public void addItem(CartItem item) {
        if (this.cartItems.contains(item)) {
            return;
        }

        this.cartItems.add(item);
    }

    public Double calculateTotal() {
        double total = 0.0;

        for (CartItem cartItem : this.cartItems) {
            total += cartItem.getSubTotal();
        }

        return total;
    }

    public boolean hasProduct(Product product) {
        return this.cartItems.stream()
            .anyMatch(item -> item.getProduct().getId().equals(product.getId()));
    }
}
