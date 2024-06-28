package com.scaler.demo.project.repositories;

import com.scaler.demo.project.dto.ProductMap;
import com.scaler.demo.project.model.Category;
import com.scaler.demo.project.model.Product;
import com.scaler.demo.project.model.projections.ProductWithIdAndName;
import com.scaler.demo.project.repository.IProductRepository;
import com.scaler.demo.project.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest

public class ProductRepositoriesTest {
    private static final Logger log = LoggerFactory.getLogger(ProductRepositoriesTest.class);
    @Autowired
    private IProductRepository iProductRepository;

//    public ProductRepositoriesTest(IProductRepository iProductRepository){
//        this.iProductRepository = iProductRepository;
//    }

    @Test
    void testQueries() throws Exception {

        Optional<Product> productOptional = iProductRepository.findById(152L);
        Product product = productOptional.get();
        if(true){
            Category category = product.getCategory();
            System.out.println(category.getName());
        }

//        //Query 1//
//        List<ProductWithIdAndName> productList = iProductRepository.getProductByIdAndName();
//        for(ProductWithIdAndName product : productList){
//            log.info("Product name : {}",product.getName());
//        }

        //Query 2//
//        List<Map<String, Object>> productMap = iProductRepository.getAllProducts();
//        List<ProductMap> products = JsonUtil.convertListOfMapToListDTO(productMap, ProductMap.class);
//        System.out.println(products);
//
//        ProductMap productMap1 = new ProductMap();
        /**
         * <name, 1>
         * <description, iphone13>
         */
    }
}
