package com.example.dist_app.cart.controller;

import com.example.dist_app.cart.facade.IShoppingCartFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/cart")
public class ShoppingCartController {

    private final IShoppingCartFacade shoppingCartFacade;

    public ShoppingCartController(IShoppingCartFacade shoppingCartFacade) {
        this.shoppingCartFacade = shoppingCartFacade;
    }

    @GetMapping("")
    public String cart(Model model) {
        model.addAttribute("cart", this.shoppingCartFacade.getShoppingCart());
        model.addAttribute("total", this.shoppingCartFacade.getCartTotal());

        return "cart/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id) {
        return this.shoppingCartFacade.addToCart(id);
    }
}
