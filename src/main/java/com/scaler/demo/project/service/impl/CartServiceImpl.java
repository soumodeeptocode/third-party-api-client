package com.scaler.demo.project.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.demo.project.dto.CartDTO;
import com.scaler.demo.project.dto.ProductDTO;
import com.scaler.demo.project.service.ICartService;
import com.scaler.demo.project.util.CartUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    private static final String GET_CART_API_ENDPOINT = "https://fakestoreapi.com/carts";
    @Override
    public List<CartDTO> getAllCarts() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        Object[] objects = restTemplate.getForObject(GET_CART_API_ENDPOINT, Object[].class);
        List<CartDTO> carts = new ObjectMapper().convertValue(objects, new TypeReference<List<CartDTO>>(){});
        //CartDTO cartsDTO = restTemplate.getForObject(GET_CART_API_ENDPOINT, CartDTO.class);
        //String response = restTemplate.getForObject(GET_CART_API_ENDPOINT, String.class);
        //List<CartDTO> cartDTOS = new ObjectMapper().readValue(response, new TypeReference<List<CartDTO>>(){});
        //ResponseEntity<Object[]> cartDTO = restTemplate.getForEntity(GET_CART_API_ENDPOINT, Object[].class);

        //Response Entity//
        ResponseEntity<List> carts_1 = restTemplate.getForEntity(GET_CART_API_ENDPOINT, List.class);
        List<CartDTO> cartDTOS = carts_1.getBody();
        return null;

        //return "Hello, my carts have " + "been loaded";
    }

    @Override
    public CartDTO addCart(CartDTO cart) {
        RestTemplate restTemplate = new RestTemplate();
        //CartDTO newCart = CartUtil.buildCartData();
        CartDTO response = restTemplate.postForObject(GET_CART_API_ENDPOINT, cart, CartDTO.class);
        return response;
    }


}
