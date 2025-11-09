package com.example.dist_app.cart;

import com.example.dist_app.products.Product;

public class CartItem {
    private Long id;
    private Product product;
    private Long quantity;

    public CartItem(
        Long id,
        Product product,
        Long quantity
    ) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return this.product.getPrice() * this.quantity;
    }
}
