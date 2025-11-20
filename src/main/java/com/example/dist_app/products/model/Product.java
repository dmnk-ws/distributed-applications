package com.example.dist_app.products.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name="Product.findBlackProducts", query="SELECT p FROM Product p WHERE p.color = 'black'"),
    @NamedQuery(name="Product.findRedProducts", query="SELECT p FROM Product p WHERE p.color = 'red'"),
    @NamedQuery(name="Product.findBlueProducts", query="SELECT p FROM Product p WHERE p.color = 'blue'")
})
public class Product {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Long size;
    private String color;

    public Product(String name, Double price,  Long size, String color) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    public Product() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
