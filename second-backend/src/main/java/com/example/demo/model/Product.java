package com.example.demo.model;

import java.math.BigDecimal;

public class Product {

    /**
     * Unique identifier for the product.
     * Used as the primary key for product lookups and references.
     */
    private Long id;

    /**
     * The display name of the product shown to customers.
     * Should be descriptive and unique within the catalog.
     */
    private String name;

    /**
     * The price of the product in Euros.
     * Represented as a BigDecimal for decimal precision in currency calculations.
     */
    private BigDecimal price;

    /**
     * The size of the product as a numeric value.
     * The unit of measurement depends on the product category (e.g., clothing size, dimensions).
     */
    private Long size;

    /**
     * The color of the product as a string value.
     * Common values include "black", "red", "blue" which can be used with named queries.
     */
    private String color;

    /**
     * The category of the product (e.g., "sale", "standard").
     * Stored as a string representation of the Category enum.
     */
    private String category;

    /**
     * Constructs a new Product with the specified attributes.
     *
     * @param name the display name of the product
     * @param price the price in Euros
     * @param size the size value of the product
     * @param color the color of the product
     * @param category the category of the product using Category enum
     */
    public Product(String name, BigDecimal price,  Long size, String color, Category category) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.category = category.getDescription();
    }

    /**
     * Constructs a new Product with the specified attributes and default STANDARD category.
     *
     * @param name the display name of the product
     * @param price the price in Euros
     * @param size the size value of the product
     * @param color the color of the product
     */
    public Product(String name, BigDecimal price, Long size, String color) {
        this(name, price, size, color, Category.STANDARD);
    }

    /**
     * Default no-argument constructor required by JPA.
     */
    public Product() {

    }

    /**
     * Returns the unique identifier of this product.
     *
     * @return the product ID as a Long value
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier for this product.
     *
     * @param id the product ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the display name of this product.
     *
     * @return the product name as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the display name for this product.
     *
     * @param name the product name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of this product in Euros.
     *
     * @return the product price as a BigDecimal value
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Sets the price for this product.
     *
     * @param price the price in Euros to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Returns the size of this product.
     *
     * @return the product size as a Long value
     */
    public Long getSize() {
        return this.size;
    }

    /**
     * Sets the size for this product.
     *
     * @param size the size value to set
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * Returns the color of this product.
     *
     * @return the product color as a String
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Sets the color for this product.
     *
     * @param color the color to set (e.g., "black", "red", "blue")
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns the category of this product.
     *
     * @return the product category as a String (e.g., "sale", "standard")
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category for this product.
     *
     * @param category the Category enum value to set
     */
    public void setCategory(Category category) {
        this.category = category.getDescription();
    }
}
