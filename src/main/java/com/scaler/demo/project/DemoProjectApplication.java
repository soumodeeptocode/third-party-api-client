package com.scaler.demo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoProjectApplication.class, args);

		List<String> listOfBeans = List.of(context.getBeanDefinitionNames());

		for(String bean : listOfBeans){
			System.out.println("Bean : "+bean);
		}

	}

}
