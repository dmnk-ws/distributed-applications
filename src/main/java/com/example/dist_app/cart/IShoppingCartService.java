package com.example.dist_app.cart;

public interface IShoppingCartService {
    ShoppingCart getShoppingCart();
    void addCartItemByProductId(Long id);
    Double getCartTotal();
}
