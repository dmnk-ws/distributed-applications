package com.example.dist_app.products.facade;

import com.example.dist_app.products.ProductDetailDTO;

public interface IProductDetailFacade {
    ProductDetailDTO getProductDetail(Long productId);
}
