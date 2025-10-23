package com.example.dist_app.products;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);
    List<Product> filter(Long id, String name, Double price, Long size, String color);
}