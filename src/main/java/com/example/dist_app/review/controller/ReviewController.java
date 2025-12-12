package com.example.dist_app.review.controller;

import com.example.dist_app.review.service.IReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
