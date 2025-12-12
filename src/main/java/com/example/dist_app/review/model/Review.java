package com.example.dist_app.review.model;

/**
 * Represents a product review submitted by a user.
 * This immutable class holds all the information about a single review,
 * including the product being reviewed and the user who submitted it.
 */
public class Review {

    /**
     * The unique identifier of the product being reviewed.
     */
    private final Long productId;

    /**
     * The name of the product being reviewed.
     */
    private final String productName;

    /**
     * The name of the user who submitted the review.
     */
    private final String userName;

    /**
     * The text content of the review.
     */
    private final String reviewText;

    /**
     * The date of the review in the format yyyy-MM-dd HH:mm:ss.
     */
    private final String date;

    /**
     * Constructs a new Review with the specified details.
     *
     * @param productId   the unique identifier of the product being reviewed
     * @param productName the name of the product being reviewed
     * @param userName    the name of the user submitting the review
     * @param reviewText  the text content of the review
     */
    public Review(
        Long productId,
        String productName,
        String userName,
        String reviewText,
        String date
    ) {
        this.productId = productId;
        this.productName = productName;
        this.userName = userName;
        this.reviewText = reviewText;
        this.date = date;
    }

    /**
     * Returns the unique identifier of the product being reviewed.
     *
     * @return the product ID
     */
    public Long getProductId() {
        return this.productId;
    }

    /**
     * Returns the name of the product being reviewed.
     *
     * @return the product name
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Returns the name of the user who submitted the review.
     *
     * @return the user name
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Returns the text content of the review.
     *
     * @return the review text
     */
    public String getReviewText() {
        return this.reviewText;
    }

    /**
     * Returns the date of the review in the format yyyy-MM-dd HH:mm:ss.
     *
     * @return the date of the review
     */
    public String getDate()  {
        return this.date;
    }
}
