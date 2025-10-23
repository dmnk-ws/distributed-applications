package com.example.dist_app.products;

import com.example.dist_app.products.Product;
import com.example.dist_app.products.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> index() {
        return Product.getProducts();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/filtered")
    public List<Product> filter(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Double price,
        @RequestParam(required = false) Long size,
        @RequestParam(required = false) String color
    ) {
        return productService.filter(id, name, price, size, color);
    }

}
