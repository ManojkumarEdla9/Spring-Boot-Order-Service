package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.example.model.Product;
import com.example.order.Order;
@Component
public class OrderprocessingService {
@Autowired
@Qualifier	
private Order creditCardPayment;
@Autowired
@Qualifier
private Order cashOnDeliveryPayment;

public void processUserOrder(com.example.model.User user,Product product,String paymentType)
{
	if("creditCard".equalsIgnoreCase(paymentType))
	{
		creditCardPayment.processOrder(user, product);
	}
	else if("cashondelivery".equalsIgnoreCase(paymentType))
	{
		cashOnDeliveryPayment.processOrder(user, product);
	}
	else
	{
		System.out.println("Invalid payment type");
		return;
	}
	saveOrderToDatabase(user,product,paymentType);
}
private void saveOrderToDatabase(com.example.model.User user,Product product,String paymentType)
{
	try 
		(Connection con=DriverManager.getConnection("jdbc:Oracle:@localhost:1521:Xe","System","Mj123"))
{
	String sql="INSERT INTO orders (User_id,product_id,payment_type)VALUES(?,?,?)";
	try 
		(PreparedStatement pstmt=con.prepareStatement(sql))
		{
			pstmt.setInt(1, user.getId());
			pstmt.setInt(2, product.getId());
			pstmt.setString(3, paymentType);
			pstmt.executeUpdate();
			System.out.println("Order saves in the Database");
		}
}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}

