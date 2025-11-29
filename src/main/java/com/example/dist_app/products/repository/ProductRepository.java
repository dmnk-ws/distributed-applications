package com.example.dist_app.products.repository;

import com.example.dist_app.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Product entity data access operations.
 * Extends JpaRepository to provide standard CRUD operations.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    /**
     * Finds all products with the color black.
     *
     * @return a list of black products
     */
    List<Product> findBlackProducts();

    /**
     * Finds all products with the color red.
     *
     * @return a list of red products
     */
    List<Product> findRedProducts();

    /**
     * Finds all products with the color blue.
     *
     * @return a list of blue products
     */
    List<Product> findBlueProducts();
}
