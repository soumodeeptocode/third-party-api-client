package com.scaler.demo.project.service.impl;

import com.scaler.demo.project.model.Product;
import com.scaler.demo.project.repository.IProductRepository;
import com.scaler.demo.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductSelfServiceImpl implements ProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Product findProductById(Long id) {
        Optional<Product> productOptional = iProductRepository.findById(1L);

        if(productOptional.isEmpty()){
            throw new RuntimeException();
        }

        Product product = productOptional.get();
        return product;
    }
}
