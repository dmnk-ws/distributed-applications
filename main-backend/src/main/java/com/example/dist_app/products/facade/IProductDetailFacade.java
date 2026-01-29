package com.example.dist_app.products.facade;

import com.example.dist_app.products.model.ProductDetailDTO;

/**
 * Facade interface for retrieving product details with stock and review information.
 */
public interface IProductDetailFacade {
    /**
     * Retrieves the product detail information including stock and reviews for a given product ID.
     *
     * @param productId the ID of the product
     * @return the product detail DTO containing product, stock, and review information
     */
    ProductDetailDTO getProductDetail(Long productId);
}
