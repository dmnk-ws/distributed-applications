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

@Controller
@RequestMapping("/mvc/products")
public class ProductCatalogController {

    private final IProductService productService;

    public ProductCatalogController(IProductService productService) {
        this.productService = productService;
    }

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
