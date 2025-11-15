package com.example.dist_app.cart.controller;

import com.example.dist_app.cart.service.IShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/cart")
public class ShoppingCartController {

    private final IShoppingCartService shoppingCartService;

    public ShoppingCartController(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("")
    public String cart(Model model) {
        model.addAttribute("cart", this.shoppingCartService.getShoppingCart());
        model.addAttribute("total", this.shoppingCartService.getCartTotal());

        return "cart/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id) {
        this.shoppingCartService.addCartItemByProductId(id);

        return "redirect:/mvc/cart";
    }
}
