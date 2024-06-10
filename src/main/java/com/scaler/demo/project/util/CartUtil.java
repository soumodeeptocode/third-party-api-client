package com.scaler.demo.project.util;

import com.scaler.demo.project.dto.CartDTO;
import com.scaler.demo.project.dto.ProductDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartUtil {

    public static CartDTO buildCartData(){
        List<ProductDTO> products = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            products.add(buildProductData(i,i));
        }
        return CartDTO.builder()
                .id(101)
                .date(new Date())
                .userId(11001)
                .products(products)
                .build();
    }

    public static ProductDTO buildProductData(int productId, int quantity){
        return ProductDTO.builder()
                .productId(productId)
                .quantity(quantity)
                .build();
    }
}
