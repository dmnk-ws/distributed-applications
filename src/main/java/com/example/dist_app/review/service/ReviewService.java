package com.example.dist_app.review.service;

import com.example.dist_app.review.model.Review;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for managing product reviews.
 * Stores reviews in memory and provides operations for retrieval and creation.
 *
 * @see IReviewService
 * @see Review
 */
@Service
public class ReviewService implements IReviewService {

    /**
     * In-memory storage for all product reviews.
     */
    private final List<Review> reviews = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    public List<Review> getReviewsForProduct(Long productId) {
        return this.reviews.stream()
            .filter(review -> review.getProductId().equals(productId))
            .toList();
    }

    /**
     * {@inheritDoc}
     */
    public void addReview(Long productId, String productName, String userName, String reviewText) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Review review = new Review(
            productId,
            productName,
            userName,
            reviewText,
            LocalDateTime.now().format(formatter)
        );

        if (!this.reviews.contains(review)) {
            this.reviews.add(review);
        }
    }
}