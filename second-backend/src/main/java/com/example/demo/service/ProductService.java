package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for managing product operations.
 * Provides CRUD operations and filtering capabilities for products.
 */
@Service
public class ProductService implements IProductService {

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products
     */
    public List<Product> getProducts() {
        return new ArrayList<>(
            List.of(
                new Product("Fancy Lightsaber", new BigDecimal("999.99"), 1L, "blue", Category.SALE),
                new Product("Fancy Jedi Book", new BigDecimal("99.99"), 1L, "brown", Category.STANDARD),
                new Product("Fancy Millennium Falcon", new BigDecimal("399.99"), 1L, "grey", Category.STANDARD),
                new Product("Fancy Stormtrooper Helmet", new BigDecimal("199.99"), 1L, "white", Category.STANDARD),
                new Product("Fancy Blaster", new BigDecimal("599.99"), 1L, "black", Category.SALE)
            )
        );
    }
}