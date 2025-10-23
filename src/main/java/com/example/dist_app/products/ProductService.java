package com.example.dist_app.products;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    public static List<Product> getProducts() {
        return List.of(
                new Product(1L, "Laptop", 999.99, 1L, "black"),
                new Product(2L, "Phone", 399.99, 1L, "black"),
                new Product(3L, "Headphones", 199.99, 1L, "black"),
                new Product(4L, "Tablet", 599.99, 1L, "black"),
                new Product(5L, "Book", 99.99, 1L, "black")
        );
    }

    public Product getProductById(Long id) {
        for (Product product : ProductService.getProducts()) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }

    public List<Product> filter(Long id, String name, Double price, Long size, String color) {
        return ProductService.getProducts().stream()
                .filter(p -> id == null || p.getId().equals(id))
                .filter(p -> name == null || p.getName().equalsIgnoreCase(name))
                .filter(p -> price == null || p.getPrice().equals(price))
                .filter(p -> size == null || p.getSize().equals(size))
                .filter(p -> color == null || p.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}