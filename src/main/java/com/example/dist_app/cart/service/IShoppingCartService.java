package com.example.dist_app.cart.service;

import com.example.dist_app.cart.model.ShoppingCart;

public interface IShoppingCartService {
    ShoppingCart getShoppingCart();
    void addCartItemByProductId(Long id);
    Double getCartTotal();
}
