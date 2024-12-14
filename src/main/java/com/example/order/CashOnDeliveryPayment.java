package com.example.order;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.example.model.Product;
@Component
public class CashOnDeliveryPayment implements Order{

	@Override
	public void processOrder(com.example.model.User user, Product product) {
		System.out.println("Order processed via cash on delievery for user: "+user.getName()+", Product: "+product.getName());
		
	}

}
