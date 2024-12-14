package com.example.order;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.model.Product;

public interface Order {
void processOrder(com.example.model.User user,Product product);
}
