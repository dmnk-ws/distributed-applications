package com.example.dist_app.products.repository;

import com.example.dist_app.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findBlackProducts();
    List<Product> findRedProducts();
    List<Product> findBlueProducts();
}
