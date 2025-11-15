package com.example.dist_app.products.controller;

import com.example.dist_app.products.service.IProductService;
import com.example.dist_app.products.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> index() {
        return this.productService.getProducts();
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

    @PostMapping("/create")
    public ResponseEntity<Product> create(
        @RequestParam String name,
        @RequestParam Double price,
        @RequestParam Long size,
        @RequestParam String color
    ) {
        Product product = this.productService.create(name, price, size, color);

        return ResponseEntity.ok(product);
    }

    @PostMapping("/create-js")
    public ResponseEntity<Product> createJS(@RequestBody Product product) {
        Product createdProduct = this.productService.create(product);

        return ResponseEntity.ok(createdProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable Long id) {
        List<Product> products = this.productService.delete(id);

        return ResponseEntity.ok(products);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(
        @PathVariable Long id,
        @RequestBody Product product
    ) {
        this.productService.update(id, product);

        return ResponseEntity.ok(
            this.productService.getProductById(id)
        );
    }
}
