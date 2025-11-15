package com.example.dist_app.cart.facade;

import com.example.dist_app.cart.model.ShoppingCart;
import com.example.dist_app.cart.service.IShoppingCartService;
import com.example.dist_app.service.IInventoryService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartFacade implements IShoppingCartFacade {
    private final IInventoryService inventoryService;
    private final IShoppingCartService shoppingCartService;

    public ShoppingCartFacade(IInventoryService inventoryService, IShoppingCartService cartService) {
        this.inventoryService = inventoryService;
        this.shoppingCartService = cartService;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCartService.getShoppingCart();
    }

    public String addToCart(Long productId) {
        if (this.inventoryService.getStockForProductId(productId) < 1) {
            return "redirect:/mvc/cart";
        }

        this.inventoryService.reduceStockForProductId(productId);
        this.shoppingCartService.addCartItemByProductId(productId);

        return "redirect:/mvc/cart";
    }

    public Double getCartTotal() {
        return this.shoppingCartService.getCartTotal();
    }
}
