package com.example.dist_app.products.facade;

import com.example.dist_app.products.service.IProductService;
import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.model.ProductDetailDTO;
import com.example.dist_app.service.IInventoryService;
import org.springframework.stereotype.Service;

/**
 * Facade service that aggregates product information with inventory data.
 * This class provides a unified view of product details by combining
 * product attributes from the product service with stock information from the inventory service.
 *
 * <p><b>Dependencies (injected via constructor):</b></p>
 * <ul>
 *   <li>{@link IProductService} - Provides product data retrieval operations</li>
 *   <li>{@link IInventoryService} - Provides stock level information for products</li>
 * </ul>
 *
 * @see IProductDetailFacade
 * @see IProductService
 * @see IInventoryService
 */
@Service
public class ProductDetailFacade implements IProductDetailFacade {

    /**
     * Service for retrieving product information from the product catalog.
     * Used to fetch product attributes like name, price, size, and color.
     */
    private final IProductService productService;

    /**
     * Service for managing and querying product inventory.
     * Used to retrieve current stock counts for products.
     */
    private final IInventoryService inventoryService;

    /**
     * Constructs a ProductDetailFacade with the required service dependencies.
     *
     * @param productService the product service for retrieving product data
     * @param inventoryService the inventory service for retrieving inventory data
     */
    public ProductDetailFacade(IProductService productService, IInventoryService inventoryService) {
        this.productService = productService;
        this.inventoryService = inventoryService;
    }

    /**
     * Retrieves comprehensive product details including current stock availability.
     * This method aggregates data from multiple services to create a detailed view
     * of a product, combining its product information with inventory data.
     *
     * @param productId the unique identifier of the product to retrieve details for
     * @return a {@link ProductDetailDTO} containing the product information and current stock level
     */
    public ProductDetailDTO getProductDetail(Long productId) {
        Product product = productService.getProductById(productId);
        Integer stock = inventoryService.getStockForProductId(productId);

        return new ProductDetailDTO(product, stock);
    }
}