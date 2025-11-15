package com.example.dist_app.products.controller;

import com.example.dist_app.products.IProductService;
import com.example.dist_app.products.Product;
import com.example.dist_app.products.ProductDetailDTO;
import com.example.dist_app.service.IInventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/product")
public class ProductDetailController {

    private final IProductService productService;
    private final IInventoryService inventoryService;

    public ProductDetailController(IProductService iProductService, IInventoryService inventoryService) {
        this.productService = iProductService;
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Product product = this.productService.getProductById(id);
        Integer stock = this.inventoryService.getStockForProductId(id);

        ProductDetailDTO productDetail = new ProductDetailDTO(product, stock);

        model.addAttribute("product", productDetail);

        return "product/details";
    }
}
