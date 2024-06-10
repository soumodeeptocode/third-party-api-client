package com.scaler.demo.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scaler.demo.project.dto.CartDTO;
import com.scaler.demo.project.service.ICartService;
import com.scaler.demo.project.service.impl.CartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService cartService;
    Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping()
    public List<CartDTO> loadAllCarts() throws JsonProcessingException {
        logger.info("Started calling cart Service");
        return cartService.getAllCarts();
    }

    @PostMapping()
    public CartDTO addCart(@RequestBody CartDTO cart){
        logger.info("Started adding a new cart {}", cart);
        return cartService.addCart(cart);
    }
}
