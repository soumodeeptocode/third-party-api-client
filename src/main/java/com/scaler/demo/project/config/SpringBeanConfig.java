package com.scaler.demo.project.config;

import com.scaler.demo.project.service.CustomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean
    public CustomService customService(){
        return new CustomService();
    }
}
