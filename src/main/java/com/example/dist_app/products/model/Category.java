package com.example.dist_app.products.model;

/**
 * Enumeration representing product categories in the catalog.
 * Categories are used to classify products for filtering and pricing purposes.
 */
public enum Category {
    SALE("sale"),
    STANDARD("standard");

    private final String description;

    /**
     * Constructs a Category with the specified description.
     *
     * @param description the human-readable description for this category
     */
    Category(String description) {
        this.description = description;
    }

    /**
     * Returns the human-readable description of this category.
     *
     * @return the category description
     */
    public String getDescription() {
        return description;
    }
}
