package com.scaler.demo.project.controller;

import com.scaler.demo.project.model.Product;
import com.scaler.demo.project.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewproduct(product);
    }
}
