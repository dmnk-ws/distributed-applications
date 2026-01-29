package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

/**
 * Service interface for managing product operations.
 */
public interface IProductService {

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    List<Product> getProducts();
}