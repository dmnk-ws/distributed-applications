package com.example.dist_app.products.controller;

import com.example.dist_app.products.Product;
import com.example.dist_app.products.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mvc/products")
public class ProductCatalogController {

    @GetMapping("")
    public String index(
        Model model,
        @RequestParam(required = false, defaultValue = "false") Boolean edit
    ) {
        List<Product> products = ProductService.getProducts();

        model.addAttribute("products", products);
        model.addAttribute("edit", edit);

        return "product/catalog";
    }
}
