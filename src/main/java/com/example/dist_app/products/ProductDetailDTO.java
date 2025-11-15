package com.example.dist_app.products;

public class ProductDetailDTO {
    public final Long id;
    public final String name;
    public final Double price;
    public final Long size;
    public final String color;
    public final Integer stock;

    public ProductDetailDTO(Product product, Integer stock) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.size = product.getSize();
        this.color = product.getColor();
        this.stock = stock;
    }

    public boolean isSoldOut() {
        return (this.stock == null || this.stock <= 0);
    }
}