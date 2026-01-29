package com.example.dist_app.products.model;

import com.example.dist_app.review.model.Review;

import java.math.BigDecimal;
import java.util.List;

/**
 * Data Transfer Object for displaying product details with stock information.
 */
public class ProductDetailDTO {
    /**
     * The unique identifier of the product.
     */
    public final Long id;

    /**
     * The name of the product.
     */
    public final String name;

    /**
     * The price of the product in Euros.
     */
    public final BigDecimal price;

    /**
     * The size of the product.
     */
    public final Long size;

    /**
     * The color of the product.
     */
    public final String color;

    /**
     * The current stock quantity of the product.
     */
    public final Integer stock;

    /**
     * The reviews for this product.
     */
    public final List<Review> reviews;

    /**
     * Creates a new ProductDetailDTO from a Product, its stock quantity, and reviews.
     *
     * @param product the product to create the DTO from
     * @param stock   the current stock quantity
     * @param reviews the reviews for this product
     */
    public ProductDetailDTO(Product product, Integer stock, List<Review> reviews) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.size = product.getSize();
        this.color = product.getColor();
        this.stock = stock;
        this.reviews = reviews;
    }

    /**
     * Checks whether the product is sold out.
     *
     * @return true if stock is null or zero or less, false otherwise
     */
    public boolean isSoldOut() {
        return (this.stock == null || this.stock <= 0);
    }
}