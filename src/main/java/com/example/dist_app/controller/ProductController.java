package com.example.dist_app.controller;

import com.example.dist_app.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/")
    public List<Product> index() {
        return Product.getProducts();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return Product.getProductById(id);
    }

    @GetMapping("/filtered")
    public List<Product> filter(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Double price,
        @RequestParam(required = false) Long size,
        @RequestParam(required = false) String color
    ) {
        return Product.filter(id, name, price, size, color);
    }

}
