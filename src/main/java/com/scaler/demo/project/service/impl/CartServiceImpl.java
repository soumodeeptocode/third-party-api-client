package com.scaler.demo.project.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.demo.project.dto.CartDTO;
import com.scaler.demo.project.dto.ProductDTO;
import com.scaler.demo.project.service.FakeStoreExceptionHandler;
import com.scaler.demo.project.service.ICartService;
import com.scaler.demo.project.util.CartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    private static final String GET_CART_API_ENDPOINT = "https://fakestoreapi.com/carts";

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<CartDTO> getAllCarts() throws JsonProcessingException {
        List<CartDTO> carts_4 = new ArrayList<>();
        //RestTemplate restTemplate = new RestTemplate();

//        //How to use getForObject/
//        String response = restTemplate.getForObject(GET_CART_API_ENDPOINT, String.class);
//        //Jackson//
//        List<CartDTO> carts = new ObjectMapper().readValue(response, new TypeReference<List<CartDTO>>() {});
//
//        Object[] responseObject = restTemplate.getForObject(GET_CART_API_ENDPOINT, Object[].class);
//        List<CartDTO> carts_1 = new ObjectMapper().convertValue(responseObject, new TypeReference<List<CartDTO>>() {});
//
//        //How to make use of GetForEntity//
//        ResponseEntity<List> responseEntity = restTemplate.getForEntity(GET_CART_API_ENDPOINT, List.class);
//        List<CartDTO> carts_3 = responseEntity.getBody();
        try{
            //ResponseEntity<String> responseString = restTemplate.getForEntity(GET_CART_API_ENDPOINT, String.class);

            ResponseEntity<String> responseString = restTemplate.exchange(GET_CART_API_ENDPOINT, HttpMethod.GET, null, String.class);
            if(responseString.getStatusCode().is2xxSuccessful()){
                 carts_4 = new ObjectMapper().readValue(responseString.getBody(), new TypeReference<List<CartDTO>>() {});
            }else{
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error getting all the carts from fake store api at : ");
                errorMessage.append(GET_CART_API_ENDPOINT);
                errorMessage.append(" responded with ");
                errorMessage.append(responseString.getStatusCode());
                errorMessage.append("Error : ");
                errorMessage.append("There is a downtime, Please try after sometime");
                throw new RuntimeException(errorMessage.toString());
            }

        }catch(Exception ex){
            throw new FakeStoreExceptionHandler(null,HttpStatus.INTERNAL_SERVER_ERROR, null);
        }


        return carts_4;

    }

    @Override
    public CartDTO addCart(CartDTO cart) {
        //RestTemplate restTemplate = new RestTemplate();
        //CartDTO newCart = CartUtil.buildCartData();
        CartDTO response = restTemplate.postForObject(GET_CART_API_ENDPOINT, cart, CartDTO.class);
        return response;
    }
}
