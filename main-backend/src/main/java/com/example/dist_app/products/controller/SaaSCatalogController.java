package com.example.dist_app.products.controller;

import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API controller for product operations.
 * Provides endpoints for browsing and managing the product catalog.
 */
@RestController
@RequestMapping("/saas/catalog")
@Tag(
    name = "SaaS Product Catalog",
    description = "API endpoints for browsing and managing the product catalog"
)
public class SaaSCatalogController {
    /**
     * Service for product operations.
     */
    private final IProductService productService;

    /**
     * Creates a new SaaSCatalogController with the specified product service.
     *
     * @param productService the product service for data operations
     */
    public SaaSCatalogController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves all products for the specified tenant.
     *
     * @param tenantId the tenant identifier from the X-TENANT-ID header
     * @return a list of products available to the tenant
     */
    @Operation(
        summary = "Get all products",
        description = "Retrieves a complete list of all products in the catalog"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved the list of products",
            content = @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Product.class))
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error"
        )
    })
    @GetMapping("/")
    public List<Product> index(
        @RequestHeader("X-TENANT-ID") String tenantId
    ) {
        return this.productService.getTenantProducts(tenantId);
    }
}
