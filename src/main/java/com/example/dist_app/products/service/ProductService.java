package com.example.dist_app.products.service;

import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public List<Product> getProducts() {
        return this.repository.findAll();
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public Product create(
        String name,
        Double price,
        Long size,
        String color
    ) {
        Product product = new Product(name, price, size, color);

        this.repository.save(product);

        return product;
    }

    public Product create(Product product) {
        this.repository.save(product);

        return product;
    }

    public List<Product> delete(Long id) {
        this.repository.deleteById(id);

        return this.repository.findAll();
    }

    public void update(Long id, Product product) {
        this.repository.findById(id).ifPresent(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setSize(product.getSize());
            p.setColor(product.getColor());
            this.repository.save(p);
        });
    }

    public Product getProductById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public List<Product> filter(Long id, String name, Double price, Long size, String color) {
        return this.repository.findAll().stream()
            .filter(p -> id == null || p.getId().equals(id))
            .filter(p -> name == null || p.getName().equalsIgnoreCase(name))
            .filter(p -> price == null || p.getPrice().equals(price))
            .filter(p -> size == null || p.getSize().equals(size))
            .filter(p -> color == null || p.getColor().equalsIgnoreCase(color))
            .collect(Collectors.toList());
    }

    public List<Product> getBlackProducts() {
        return this.repository.findBlackProducts();
    }

    public List<Product> getRedProducts() {
        return this.repository.findRedProducts();
    }

    public List<Product> getBlueProducts() {
        return this.repository.findBlueProducts();
    }

    public Page<Product> getPagedProducts(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}