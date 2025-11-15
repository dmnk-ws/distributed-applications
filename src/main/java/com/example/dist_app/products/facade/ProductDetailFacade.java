package com.example.dist_app.products.facade;

import com.example.dist_app.products.service.IProductService;
import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.model.ProductDetailDTO;
import com.example.dist_app.service.IInventoryService;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailFacade implements IProductDetailFacade {

    private final IProductService productService;
    private final IInventoryService inventoryService;

    public ProductDetailFacade(IProductService productService, IInventoryService inventoryService) {
        this.productService = productService;
        this.inventoryService = inventoryService;
    }

    public ProductDetailDTO getProductDetail(Long productId) {
        Product product = productService.getProductById(productId);
        Integer stock = inventoryService.getStockForProductId(productId);

        return new ProductDetailDTO(product, stock);
    }
}