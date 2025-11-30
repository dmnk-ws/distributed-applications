package com.example.dist_app.cart.model;

import com.example.dist_app.products.model.Product;

import java.math.BigDecimal;

/**
 * Represents an item in a shopping cart, containing a product and its quantity.
 */
public class CartItem {
    /**
     * The unique identifier for this cart item.
     */
    private Long id;

    /**
     * The product associated with this cart item.
     */
    private Product product;

    /**
     * The quantity of the product in the cart.
     */
    private Long quantity;

    /**
     * Creates a new cart item with the specified id, product, and quantity.
     *
     * @param id       the unique identifier for this cart item
     * @param product  the product to add to the cart
     * @param quantity the quantity of the product
     */
    public CartItem(
        Long id,
        Product product,
        Long quantity
    ) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the unique identifier of this cart item.
     *
     * @return the cart item ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of this cart item.
     *
     * @param id the cart item ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the product associated with this cart item.
     *
     * @return the product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Sets the product associated with this cart item.
     *
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the quantity of the product in the cart.
     *
     * @return the quantity
     */
    public Long getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity of the product in the cart.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * Calculates and returns the subtotal for this cart item (price * quantity).
     *
     * @return the subtotal in Euros
     */
    public BigDecimal getSubTotal() {
        return this.product.getPrice().multiply(BigDecimal.valueOf(this.quantity));
    }
}
