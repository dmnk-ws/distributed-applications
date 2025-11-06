package com.example.dist_app.products.controller;

import com.example.dist_app.products.IProductService;
import com.example.dist_app.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/product")
public class ProductDetailController {

    private final IProductService productService;

    public ProductDetailController(IProductService iProductService) {
        this.productService = iProductService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Product product = this.productService.getProductById(id);

        model.addAttribute("product", product);

        return "product/details";
    }
}
