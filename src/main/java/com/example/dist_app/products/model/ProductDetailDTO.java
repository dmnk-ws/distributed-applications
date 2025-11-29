package com.example.dist_app.products.model;

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
    public final Double price;

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
     * Creates a new ProductDetailDTO from a Product and its stock quantity.
     *
     * @param product the product to create the DTO from
     * @param stock   the current stock quantity
     */
    public ProductDetailDTO(Product product, Integer stock) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.size = product.getSize();
        this.color = product.getColor();
        this.stock = stock;
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