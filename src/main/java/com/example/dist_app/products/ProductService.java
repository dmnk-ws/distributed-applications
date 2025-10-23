package com.example.dist_app.products;

import com.example.dist_app.products.Product;
import com.example.dist_app.products.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    public Product getProductById(Long id) {
        for (Product product : Product.getProducts()) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }

    public List<Product> filter(Long id, String name, Double price, Long size, String color) {
        return Product.getProducts().stream()
                .filter(p -> id == null || p.getId().equals(id))
                .filter(p -> name == null || p.getName().equalsIgnoreCase(name))
                .filter(p -> price == null || p.getPrice().equals(price))
                .filter(p -> size == null || p.getSize().equals(size))
                .filter(p -> color == null || p.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}