package com.example.dist_app.products.controller;

import com.example.dist_app.products.service.IProductService;
import com.example.dist_app.products.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Spring MVC controller for displaying product catalog pages.
 * Provides endpoints for viewing, filtering, and paginating products.
 */
@Controller
@RequestMapping("/mvc/products")
public class ProductCatalogController {

    /**
     * Service for product operations.
     */
    private final IProductService productService;

    /**
     * Creates a new ProductCatalogController with the specified product service.
     *
     * @param productService the product service for data operations
     */
    public ProductCatalogController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Displays the product catalog page with all products.
     *
     * @param model the Spring MVC model to add attributes to
     * @param edit  whether edit mode is enabled
     * @return the name of the catalog view template
     */
    @GetMapping("")
    public String index(
        Model model,
        @RequestParam(required = false, defaultValue = "false") Boolean edit
    ) {
        List<Product> products = this.productService.getProducts();

        model.addAttribute("products", products);
        model.addAttribute("edit", edit);

        return "product/catalog";
    }

    /**
     * Displays the product catalog filtered by color.
     *
     * @param model the Spring MVC model to add attributes to
     * @param color the color to filter by (black, red, blue, or all)
     * @return the name of the catalog view template
     */
    @GetMapping("/filter")
    public String filter(
        Model model,
        @RequestParam(required = false, defaultValue = "all") String color
    ) {
        List<Product> products = switch (color) {
            case "black" -> this.productService.getBlackProducts();
            case "red" -> this.productService.getRedProducts();
            case "blue" -> this.productService.getBlueProducts();
            default -> this.productService.getProducts();
        };

        model.addAttribute("products", products);

        return "product/catalog";
    }

    /**
     * Displays a paginated view of the product catalog.
     *
     * @param pageable the pagination information (defaults to 3 items per page)
     * @param edit     whether edit mode is enabled
     * @param model    the Spring MVC model to add attributes to
     * @return the name of the paginated catalog view template
     */
    @GetMapping("/paginated")
    public String paginated(
        @PageableDefault(size=3) Pageable pageable,
        @RequestParam(required = false, defaultValue = "false") Boolean edit,
        Model model
    ) {
        Page<Product> products = this.productService.getPagedProducts(pageable);

        model.addAttribute("products", products.getContent());
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("total", products.getTotalElements());
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("edit", edit);

        return "product/paginated-catalog";
    }
}
