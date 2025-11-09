package com.example.dist_app.cart;

import com.example.dist_app.products.Product;
import com.example.dist_app.products.ProductService;
import com.example.dist_app.user.Address;
import com.example.dist_app.user.Gender;
import com.example.dist_app.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ShoppingCartService implements IShoppingCartService {

    private final AtomicLong cartItemIdCounter = new AtomicLong(3);
    private final ProductService productService;
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
                    new Product(3L, "Stormtrooper Helmet", 199.99, 1L, "white"),
                    3L
                ),
                new CartItem(
                    2L,
                    new Product(4L, "Blaster", 599.99, 1L, "black"),
                    1L
                )
            )
        )
    );

    public ShoppingCartService(ProductService productService) {
        this.productService = productService;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

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

    public Double getCartTotal() {
        return this.shoppingCart.calculateTotal();
    }
}
