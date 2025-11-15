package com.example.dist_app.products.facade;

import com.example.dist_app.products.model.ProductDetailDTO;

public interface IProductDetailFacade {
    ProductDetailDTO getProductDetail(Long productId);
}
