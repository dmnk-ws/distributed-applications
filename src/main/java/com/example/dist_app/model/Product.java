package com.example.dist_app.model;

import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Long size;
    private String color;

    public Product(Long id, String name, Double price,  Long size, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static List<Product> getProducts() {
        return List.of(
            new Product(1L, "Laptop", 999.99, 1L, "black"),
            new Product(2L, "Phone", 399.99, 1L, "black"),
            new Product(3L, "Headphones", 199.99, 1L, "black"),
            new Product(4L, "Tablet", 599.99, 1L, "black"),
            new Product(5L, "Book", 99.99, 1L, "black")
        );
    }

    public static Product getProductById(Long id) {
        for (Product product : getProducts()) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }

    public static List<Product> filter(Long id, String name, Double price, Long size, String color) {
        return Product.getProducts().stream()
            .filter(p -> id == null || p.getId().equals(id))
            .filter(p -> name == null || p.getName().equalsIgnoreCase(name))
            .filter(p -> price == null || p.getPrice().equals(price))
            .filter(p -> size == null || p.getSize().equals(size))
            .filter(p -> color == null || p.getColor().equalsIgnoreCase(color))
            .collect(Collectors.toList());
    }
}
