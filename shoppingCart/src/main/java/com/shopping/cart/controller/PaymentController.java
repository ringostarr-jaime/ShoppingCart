package com.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shopping.cart.interfaces.order.OrderInterfaces;
import com.shopping.cart.interfaces.payment.PaymentInterfaces;
import com.shopping.cart.models.dto.order.OrderDto;
import com.shopping.cart.models.dto.payment.Payment;
import com.shopping.cart.models.dto.order.ClientDto;
import com.shopping.cart.utilidades.ErrorExceptionHandler;

import jakarta.validation.Valid;


@RestController
@RequestMapping("${payment.version}")
public class PaymentController extends ErrorExceptionHandler {
	
	@Autowired
	private PaymentInterfaces apiService;

	
	@PostMapping("/paymentCash")
	public ResponseEntity<Object> paymentCash(@Valid @RequestBody Payment pay) 
	{ 
		return apiService.paymentCash(pay);
	}
	
	
}
