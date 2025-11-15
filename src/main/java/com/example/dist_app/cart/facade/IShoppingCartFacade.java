package com.example.dist_app.cart.facade;

import com.example.dist_app.cart.model.ShoppingCart;

public interface IShoppingCartFacade {
    ShoppingCart getShoppingCart();
    String addToCart(Long productId);
    Double getCartTotal();
}
