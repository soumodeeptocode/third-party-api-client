package com.scaler.demo.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scaler.demo.project.dto.CartDTO;
import com.scaler.demo.project.service.ICartService;
import com.scaler.demo.project.service.impl.CartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService cartService;
    Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<CartDTO>> loadAllCarts() throws JsonProcessingException {
        logger.info("Started calling cart Service");
//        List<CartDTO> response = cartService.getAllCarts();
//        return new ResponseEntity<>(response, HttpStatus.OK);
        ResponseEntity<List<CartDTO>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<CartDTO> response = cartService.getAllCarts();
        if(!CollectionUtils.isEmpty(response)){
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        return responseEntity;
    }

    @PostMapping()
    public CartDTO addCart(@RequestBody CartDTO cart){
        logger.info("Started adding a new cart {}", cart);
        return cartService.addCart(cart);
    }
}
