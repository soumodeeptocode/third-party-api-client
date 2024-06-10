package com.scaler.demo.project.service;


import com.razorpay.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.http.HttpClient;

public class CustomService {
 HttpClient httpClient;
    public CustomService(){
        System.out.println("I am being instantiated at the time of startup");
    }
}
