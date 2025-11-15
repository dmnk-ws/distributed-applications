package com.example.dist_app.products.service;

import com.example.dist_app.products.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();
    void add(Product product);
    Product create(String name, Double price, Long size, String color);
    Product create(Product product);
    List<Product> delete(Long id);
    void update(Long id, Product product);
    Product getProductById(Long id);
    List<Product> filter(Long id, String name, Double price, Long size, String color);
}