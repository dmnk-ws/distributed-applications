package com.example.dist_app.products.controller;

import com.example.dist_app.products.model.ProductDetailDTO;
import com.example.dist_app.products.facade.IProductDetailFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring MVC controller for displaying product detail pages.
 * Provides endpoints for viewing individual product details with stock information.
 */
@Controller
@RequestMapping("/mvc/product")
public class ProductDetailController {

    /**
     * Facade for retrieving product details.
     */
    private final IProductDetailFacade productDetailFacade;

    /**
     * Creates a new ProductDetailController with the specified facade.
     *
     * @param productDetailFacade the facade for product detail operations
     */
    public ProductDetailController(IProductDetailFacade productDetailFacade) {
        this.productDetailFacade = productDetailFacade;
    }

    /**
     * Displays the product detail page for a specific product.
     *
     * @param id    the ID of the product to display
     * @param model the Spring MVC model to add attributes to
     * @return the name of the product details view template
     */
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        ProductDetailDTO productDetail = productDetailFacade.getProductDetail(id);

        model.addAttribute("product", productDetail);

        return "product/details";
    }
}
