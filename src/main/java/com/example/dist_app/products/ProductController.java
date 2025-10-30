package com.example.dist_app.products;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final AtomicLong counter = new AtomicLong(6);
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

    @PostMapping("/create")
    public ResponseEntity<Product> create(
        @RequestParam String name,
        @RequestParam Double price,
        @RequestParam Long size,
        @RequestParam String color
    ) {
        Product product = new Product(
            counter.incrementAndGet(),
            name,
            price,
            size,
            color
        );

        ProductService.add(product);

        return ResponseEntity.ok(product);
    }

    @PostMapping("/create-js")
    public ResponseEntity<Product> createJS(@RequestBody Product product) {
        Long id = counter.incrementAndGet();
        product.setId(id);
        ProductService.add(product);

        return ResponseEntity.ok(
            this.productService.getProductById(id)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable Long id) {
        List<Product> products = ProductService.delete(id);

        return ResponseEntity.ok(products);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> update(
        @PathVariable Long id,
        @RequestBody Product product
    ) {
        ProductService.update(id, product);

        return ResponseEntity.ok(
            this.productService.getProductById(id)
        );
    }
}
