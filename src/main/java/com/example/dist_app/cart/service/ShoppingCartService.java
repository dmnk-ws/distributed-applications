package com.example.dist_app.cart.service;

import com.example.dist_app.cart.model.CartItem;
import com.example.dist_app.cart.model.ShoppingCart;
import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.service.IProductService;
import com.example.dist_app.service.IPriceCalculationService;
import com.example.dist_app.user.model.Address;
import com.example.dist_app.user.model.Gender;
import com.example.dist_app.user.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service implementation for managing shopping cart operations.
 * Provides functionality to retrieve, modify, and calculate totals for a shopping cart.
 */
@Service
public class ShoppingCartService implements IShoppingCartService {

    /**
     * Counter for generating unique cart item IDs.
     */
    private final AtomicLong cartItemIdCounter = new AtomicLong(3);

    /**
     * Service for retrieving product information.
     */
    private final IProductService productService;

    /**
     * Service for price calculations.
     */
    private final IPriceCalculationService priceCalculationService;

    /**
     * Temporary fixture data.
     */
    private final ShoppingCart shoppingCart = new ShoppingCart(
        1L,
        new User(
            1L,
            "Sheev",
            "Palpatine",
            "sheev.palpatine@example.org",
            new Address(1L, "00001", "Imperial Palace", "Coruscant", "Galactic Empire"),
            Gender.MALE
        ),
        new ArrayList<>(
            List.of(
                new CartItem(
                    1L,
                    new Product("Stormtrooper Helmet", new BigDecimal("199.99"), 1L, "white"),
                    3L
                ),
                new CartItem(
                    2L,
                    new Product("Blaster", new BigDecimal("599.99"), 1L, "black"),
                    1L
                )
            )
        )
    );

    /**
     * Creates a new ShoppingCartService with the specified services.
     *
     * @param productService the product service for retrieving product information
     * @param priceCalculationService the price calculation service
     */
    public ShoppingCartService(IProductService productService, IPriceCalculationService  priceCalculationService) {
        this.productService = productService;
        this.priceCalculationService = priceCalculationService;
    }

    /**
     * Retrieves the current shopping cart.
     *
     * @return the shopping cart
     */
    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    /**
     * Adds a product to the cart by its ID. If the product already exists in the cart,
     * its quantity is incremented by one. If the product does not exist, nothing happens.
     *
     * @param id the ID of the product to add
     */
    public void addCartItemByProductId(Long id) {
        Product product = this.productService.getProductById(id);

        if (product == null) {
            return;
        }

        if (this.shoppingCart.hasProduct(product)) {
            CartItem existingItem = this.shoppingCart.getCartItemByProductId(product.getId());
            existingItem.setQuantity(existingItem.getQuantity() + 1);
        } else {
            this.shoppingCart.addItem(
                new CartItem(
                    this.cartItemIdCounter.incrementAndGet(),
                    product,
                    1L
                )
            );
        }
    }

    /**
     * Calculates and returns the total price of all items in the cart.
     *
     * @return the total price in Euros rounded to two digits
     */
    public BigDecimal getCartTotal() {
        return this.priceCalculationService.round(
            this.shoppingCart.calculateTotal()
        );
    }
}
