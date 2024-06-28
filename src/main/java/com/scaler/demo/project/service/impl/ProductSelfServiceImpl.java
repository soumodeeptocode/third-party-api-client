package com.scaler.demo.project.service.impl;

import com.scaler.demo.project.model.Category;
import com.scaler.demo.project.model.Product;
import com.scaler.demo.project.repository.ICategoryRepository;
import com.scaler.demo.project.repository.IProductRepository;
import com.scaler.demo.project.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSelfServiceImpl implements ProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Product findProductById(Long id) {
        Optional<Product> productOptional = iProductRepository.findById(1L);

        if(productOptional.isEmpty()){
            throw new RuntimeException();
        }

        Product product = productOptional.get();
        return product;
    }

    @Override
    @Transactional
    public Product addNewproduct(Product product) {
        Optional<Category> categoryOptional = iCategoryRepository.findByName(product.getCategory().getName());
        Category category = categoryOptional.get();
        List<Product> productList = category.getProducts();
        for(Product product1 : productList){
            System.out.println(product1.getName());
        }
        return null;

//        if(categoryOptional.isEmpty()){
//           // product.setCategory(iCategoryRepository.save(product.getCategory()));
//        }else{
//            product.setCategory(categoryOptional.get());
//        }
//
//        return iProductRepository.save(product);
    }
}
