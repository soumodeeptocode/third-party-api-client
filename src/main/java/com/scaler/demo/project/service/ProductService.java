package com.scaler.demo.project.service;

import com.scaler.demo.project.model.Product;

public interface ProductService {
    Product findProductById(Long id);

    Product addNewproduct(Product product);
}
