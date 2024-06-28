package com.scaler.demo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class DemoProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoProjectApplication.class, args);

		List<String> listOfBeans = List.of(context.getBeanDefinitionNames());

//		for(String bean : listOfBeans){
//			System.out.println("Bean : "+bean);
//		}

	}

}
