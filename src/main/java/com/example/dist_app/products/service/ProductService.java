package com.example.dist_app.products.service;

import com.example.dist_app.products.model.Product;
import com.example.dist_app.products.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing product operations.
 * Provides CRUD operations and filtering capabilities for products.
 */
@Service
public class ProductService implements IProductService {

    /**
     * Repository for product data access.
     */
    private final ProductRepository repository;

    /**
     * Creates a new ProductService with the specified repository.
     *
     * @param productRepository the product repository for data access
     */
    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products
     */
    public List<Product> getProducts() {
        return this.repository.findAll();
    }

    /**
     * Adds a product to the repository.
     *
     * @param product the product to add
     */
    public void add(Product product) {
        this.repository.save(product);
    }

    /**
     * Creates a new product with the specified attributes and saves it.
     *
     * @param name  the name of the product
     * @param price the price of the product in Euros
     * @param size  the size of the product
     * @param color the color of the product
     * @return the created product
     */
    public Product create(
        String name,
        BigDecimal price,
        Long size,
        String color
    ) {
        Product product = new Product(name, price, size, color);

        this.repository.save(product);

        return product;
    }

    /**
     * Creates and saves a new product from an existing product object.
     *
     * @param product the product to create
     * @return the created product
     */
    public Product create(Product product) {
        this.repository.save(product);

        return product;
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return the list of remaining products after deletion
     */
    public List<Product> delete(Long id) {
        this.repository.deleteById(id);

        return this.repository.findAll();
    }

    /**
     * Updates an existing product with new values.
     *
     * @param id      the ID of the product to update
     * @param product the product containing updated values
     */
    public void update(Long id, Product product) {
        this.repository.findById(id).ifPresent(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setSize(product.getSize());
            p.setColor(product.getColor());
            this.repository.save(p);
        });
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product, or null if not found
     */
    public Product getProductById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    /**
     * Filters products by the specified criteria. All parameters are optional.
     *
     * @param id    the product ID to filter by
     * @param name  the product name to filter by
     * @param price the product price to filter by
     * @param size  the product size to filter by
     * @param color the product color to filter by
     * @return a list of products matching the criteria
     */
    public List<Product> filter(Long id, String name, BigDecimal price, Long size, String color) {
        return this.repository.findAll().stream()
            .filter(p -> id == null || p.getId().equals(id))
            .filter(p -> name == null || p.getName().equalsIgnoreCase(name))
            .filter(p -> price == null || p.getPrice().equals(price))
            .filter(p -> size == null || p.getSize().equals(size))
            .filter(p -> color == null || p.getColor().equalsIgnoreCase(color))
            .collect(Collectors.toList());
    }

    /**
     * Retrieves all products with the color black.
     *
     * @return a list of black products
     */
    public List<Product> getBlackProducts() {
        return this.repository.findBlackProducts();
    }

    /**
     * Retrieves all products with the color red.
     *
     * @return a list of red products
     */
    public List<Product> getRedProducts() {
        return this.repository.findRedProducts();
    }

    /**
     * Retrieves all products with the color blue.
     *
     * @return a list of blue products
     */
    public List<Product> getBlueProducts() {
        return this.repository.findBlueProducts();
    }

    /**
     * Retrieves a paginated list of products.
     *
     * @param pageable the pagination information
     * @return a page of products
     */
    public Page<Product> getPagedProducts(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}