package com.example.order;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.example.model.Product;
@Component
public class CreditPayment implements Order{

	@Override
	public void processOrder(com.example.model.User user, Product product) {
		// TODO Auto-generated method stub
		System.out.println("order processed via crdit card for user :"+user.getName()+"product: "+product.getName());
		
	}

}
