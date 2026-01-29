package com.example.dist_app.review.controller;

import com.example.dist_app.review.model.Review;
import com.example.dist_app.review.service.IReviewService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

/**
 * Controller for handling product review operations.
 * Provides endpoints for creating and managing product reviews.
 *
 * @see IReviewService
 */
@Controller
@RequestMapping("/mvc/review")
public class ReviewController {

    /**
     * Service for managing product reviews.
     */
    private final IReviewService reviewService;

    /**
     * Constructs a ReviewController with the required service dependency.
     *
     * @param reviewService the review service for managing reviews
     */
    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Creates a new review for a product.
     * After successful creation, redirects to the product detail page.
     *
     * @param productId   the unique identifier of the product being reviewed
     * @param productName the name of the product being reviewed
     * @param userName    the name of the user submitting the review
     * @param reviewText  the content of the review
     * @return a redirect to the product detail page
     */
    @PostMapping("/create")
    public String create(
        @RequestParam Long productId,
        @RequestParam String productName,
        @RequestParam String userName,
        @RequestParam String reviewText
    ) {
        reviewService.addReview(productId, productName, userName, reviewText);

        return "redirect:/mvc/product/" + productId;
    }

    /**
     * Handles incoming WebSocket messages for creating reviews.
     * Processes the review with a small delay and broadcasts it to all subscribers.
     *
     * @param review the review object received via WebSocket message
     * @return the processed review to be broadcast to subscribers on /topic/review
     * @throws Exception if an error occurs during processing
     */
    @MessageMapping("/review")
    @SendTo("/topic/review")
    public Review review(Review review) throws Exception {
        Thread.sleep(1000);

        this.reviewService.addReview(
            review.getProductId(),
            review.getProductName(),
            review.getUserName(),
            review.getReviewText()
        );

        return review;
    }
}
