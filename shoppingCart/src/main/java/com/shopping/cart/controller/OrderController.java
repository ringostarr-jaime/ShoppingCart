package com.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shopping.cart.interfaces.order.OrderInterfaces;
import com.shopping.cart.models.dto.order.OrderDto;
import com.shopping.cart.models.dto.order.ClientDto;
import com.shopping.cart.utilidades.ErrorExceptionHandler;

import jakarta.validation.Valid;


@RestController
@RequestMapping("${order.version}")
public class OrderController extends ErrorExceptionHandler {
	
	@Autowired
	private OrderInterfaces apiService;

	
	@PostMapping("/addProductCart")
	public ResponseEntity<Object> addProductCart(@Valid @RequestBody OrderDto order) 
	{ 
		return apiService.addProductCart(order);
	}
	
	//----Solo retornara data si ya se agrego productos al carrito
	@PostMapping("/getOrder")
	public ResponseEntity<Object> getOrder(@Valid @RequestBody ClientDto order) 
	{ 
		return apiService.getOrder(order);
	}
	
	@PostMapping("/deleteProdOrder")
	public ResponseEntity<Object> deleteProdOrder(@Valid @RequestBody OrderDto order) 
	{ 
		return apiService.deleteProdOrder(order);
	}
	
	@PostMapping("/modProductCart")
	public ResponseEntity<Object> modProductCart(@Valid @RequestBody OrderDto order) 
	{ 
		return apiService.modProductCart(order);
	}
	
}
