package com.shopping.cart.interfaces.order;

import org.springframework.http.ResponseEntity;

import com.shopping.cart.models.dto.order.OrderDto;
import com.shopping.cart.models.dto.order.ClientDto;
import com.shopping.cart.models.dto.order.DeleteOrderDto;

public interface OrderInterfaces {
	
	ResponseEntity<Object> addProductCart (OrderDto order);
	ResponseEntity<Object> getOrder (ClientDto order);
	ResponseEntity<Object> deleteProdOrder (DeleteOrderDto order);
	ResponseEntity<Object> modProductCart (OrderDto order);
}
