package com.example.dist_app.products.service;

import com.example.dist_app.products.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final AtomicLong productIdCounter = new AtomicLong(6);
    private final List<Product> products = new ArrayList<>(
        List.of(
            new Product(1L, "Lightsaber", 999.99, 1L, "blue"),
            new Product(2L, "Millennium Falcon", 399.99, 1L, "grey"),
            new Product(3L, "Stormtrooper Helmet", 199.99, 1L, "white"),
            new Product(4L, "Blaster", 599.99, 1L, "black"),
            new Product(5L, "Jedi Book", 99.99, 1L, "brown")
        )
    );

    public List<Product> getProducts() {
        return this.products;
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public Product create(
        String name,
        Double price,
        Long size,
        String color
    ) {
        Product product = new Product(
            this.productIdCounter.incrementAndGet(),
            name,
            price,
            size,
            color
        );

        this.products.add(product);

        return product;
    }

    public Product create(Product product) {
        product.setId(this.productIdCounter.incrementAndGet());
        this.products.add(product);

        return product;
    }

    public List<Product> delete(Long id) {
        this.products.removeIf(product -> product.getId().equals(id));

        return this.getProducts();
    }

    public void update(Long id, Product product) {
        for (Product p : this.getProducts()) {
            if (p.getId().equals(id)) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setSize(product.getSize());
                p.setColor(product.getColor());

                break;
            }
        }
    }

    public Product getProductById(Long id) {
        for (Product product : this.getProducts()) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }

    public List<Product> filter(Long id, String name, Double price, Long size, String color) {
        return this.getProducts().stream()
            .filter(p -> id == null || p.getId().equals(id))
            .filter(p -> name == null || p.getName().equalsIgnoreCase(name))
            .filter(p -> price == null || p.getPrice().equals(price))
            .filter(p -> size == null || p.getSize().equals(size))
            .filter(p -> color == null || p.getColor().equalsIgnoreCase(color))
            .collect(Collectors.toList());
    }
}