package com.example.dist_app.products.controller;

import com.example.dist_app.products.model.ProductDetailDTO;
import com.example.dist_app.products.facade.IProductDetailFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/product")
public class ProductDetailController {

    private final IProductDetailFacade productDetailFacade;

    public ProductDetailController(IProductDetailFacade productDetailFacade) {
        this.productDetailFacade = productDetailFacade;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        ProductDetailDTO productDetail = productDetailFacade.getProductDetail(id);

        model.addAttribute("product", productDetail);

        return "product/details";
    }
}
