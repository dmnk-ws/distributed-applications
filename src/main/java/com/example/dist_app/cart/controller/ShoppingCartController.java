package com.example.dist_app.cart.controller;

import com.example.dist_app.cart.facade.IShoppingCartFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring MVC controller for handling shopping cart web requests.
 * Provides endpoints for viewing the cart and adding items to it.
 */
@Controller
@RequestMapping("/mvc/cart")
public class ShoppingCartController {

    /**
     * Facade for shopping cart operations.
     */
    private final IShoppingCartFacade shoppingCartFacade;

    /**
     * Creates a new ShoppingCartController with the specified facade.
     *
     * @param shoppingCartFacade the facade for shopping cart operations
     */
    public ShoppingCartController(IShoppingCartFacade shoppingCartFacade) {
        this.shoppingCartFacade = shoppingCartFacade;
    }

    /**
     * Displays the shopping cart page with all cart items and the total price.
     *
     * @param model the Spring MVC model to add attributes to
     * @return the name of the cart view template
     */
    @GetMapping("")
    public String cart(Model model) {
        model.addAttribute("cart", this.shoppingCartFacade.getShoppingCart());
        model.addAttribute("total", this.shoppingCartFacade.getCartTotal());

        return "cart/cart";
    }

    /**
     * Adds a product to the shopping cart by its ID.
     *
     * @param id the ID of the product to add
     * @return a redirect URL string
     */
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id) {
        return this.shoppingCartFacade.addToCart(id);
    }
}
