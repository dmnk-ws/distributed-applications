package com.example.dist_app.products;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private static final List<Product> products = new ArrayList<>(
        List.of(
            new Product(1L, "Lightsaber", 999.99, 1L, "blue"),
            new Product(2L, "Millennium Falcon", 399.99, 1L, "grey"),
            new Product(3L, "Stormtrooper Helmet", 199.99, 1L, "white"),
            new Product(4L, "Blaster", 599.99, 1L, "black"),
            new Product(5L, "Jedi Book", 99.99, 1L, "brown")
        )
    );

    public static List<Product> getProducts() {
        return ProductService.products;
    }

    public static void add(Product product) {
        ProductService.products.add(product);
    }

    public static List<Product> delete(Long id) {
        ProductService.products.removeIf(product -> product.getId().equals(id));

        return ProductService.getProducts();
    }

    public static void update(Long id, Product product) {
        for (Product p : getProducts()) {
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