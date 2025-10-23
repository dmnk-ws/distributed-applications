package com.example.dist_app.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> index() {
        return ProductService.getProducts();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("/filtered")
    public List<Product> filter(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Double price,
        @RequestParam(required = false) Long size,
        @RequestParam(required = false) String color
    ) {
        return this.productService.filter(id, name, price, size, color);
    }

}
