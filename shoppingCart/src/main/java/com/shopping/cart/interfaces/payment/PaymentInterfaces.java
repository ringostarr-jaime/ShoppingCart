package com.shopping.cart.interfaces.payment;

import org.springframework.http.ResponseEntity;

import com.shopping.cart.models.dto.payment.Payment;

public interface PaymentInterfaces {
	
	ResponseEntity<Object> paymentCash(Payment pay);
}
