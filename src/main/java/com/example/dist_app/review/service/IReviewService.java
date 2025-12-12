package com.example.dist_app.review.service;

import com.example.dist_app.review.model.Review;

import java.util.List;

/**
 * Service interface for managing product reviews.
 * Provides operations for retrieving and creating reviews.
 *
 * @see Review
 */
public interface IReviewService {

    /**
     * Retrieves all reviews for a specific product.
     *
     * @param productId the unique identifier of the product
     * @return a list of reviews for the specified product, or an empty list if none exist
     */
    List<Review> getReviewsForProduct(Long productId);

    /**
     * Adds a new review for a product.
     *
     * @param productId   the unique identifier of the product being reviewed
     * @param productName the name of the product being reviewed
     * @param userName    the name of the user submitting the review
     * @param reviewText  the text content of the review
     */
    void addReview(Long productId, String productName, String userName, String reviewText);
}
