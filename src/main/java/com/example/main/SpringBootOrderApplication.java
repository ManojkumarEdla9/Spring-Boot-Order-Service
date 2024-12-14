package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.OrderprocessingService;

@SpringBootApplication
public class SpringBootOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrderApplication.class, args);
	
	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
	OrderprocessingService orderProcessingService=context.getBean(OrderprocessingService.class);
	
	User user=new User(0);
	user.setId(1);
	user.setName("Manoj");
	user.setEmail("mke9@gmail.com");
	user.setAddress("Hyderabad");
	
	Product product=new Product();
	product.setId(1);
	product.setName("Laptop");
	product.setPrice(50000);
	product.setId(2);
	product.setName("Smartphone");
	product.setPrice(30000);
	product.setId(3);
	product.setName("phone");
	product.setPrice(80000);
	
	
	orderProcessingService.processUserOrder(user, product, "creditcard");
	orderProcessingService.processUserOrder(user, product, "cashOnDelivery");
	}
}
