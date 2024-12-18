package com.shopping.cart.implement.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.shopping.cart.interfaces.order.OrderInterfaces;
import com.shopping.cart.models.dto.order.OrderDto;
import com.shopping.cart.models.dto.order.ProductOrder;
import com.shopping.cart.models.dto.order.ClientDto;
import com.shopping.cart.utilidades.ErrorExceptionHandler;

@Service
public class OrderService extends ErrorExceptionHandler implements OrderInterfaces{
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public static List<OrderDto> listCart = new ArrayList<>();
	public List<ProductOrder> listProduct = new ArrayList<>();
	
	@Override
	public ResponseEntity<Object> addProductCart(OrderDto order) {
		try {
			listCart.clear();
			listProduct.clear();
			ResponseEntity<Object> responseEntity = null;			
			OrderDto cart = new OrderDto();		
			cart.setDate(order.getDate());
			cart.setUserId(order.getUserId());		
			logger.info("LIST FILLING addProductCart");
			for (int i = 0; i < order.getProducts().size(); i++) {
				ProductOrder prOrder = new ProductOrder();
				prOrder.setProductId(order.getProducts().get(i).getProductId());
				prOrder.setQuantity(order.getProducts().get(i).getQuantity());			
				Double price = order.getProducts().get(i).getQuantity() * order.getProducts().get(i).getPrice();
				prOrder.setPrice(price);			
				listProduct.add(prOrder);				
			}		
			cart.setProducts(listProduct);		
			listCart.add(cart);
			logger.info("completed successfully addProductCart");
			return responseEntity.ok(listCart);
		} catch (Exception e) {
			logger.info("ERROR ON addProductCart {}",e);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("The service is unable to respond at the moment");
		}		
		
	}

	@Override
	public ResponseEntity<Object> getOrder(ClientDto order) {
		try {
			ResponseEntity<Object> responseEntity = null;	
			if(!listCart.isEmpty()
					&& (order.getUserId()==listCart.get(0).getUserId()
					&& order.getDate().trim().equals(listCart.get(0).getDate().trim())))
			{
				logger.info("completed successfully getOrder");
				return responseEntity.ok(listCart);	
			}
			return ResponseEntity.noContent().build();		
		} catch (Exception e) {
			logger.info("ERROR ON getOrder {}",e);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("The service is unable to respond at the moment");
		}		
		
	}
	
	@Override
	public ResponseEntity<Object> deleteProdOrder(OrderDto order) {
		
		try {
			ResponseEntity<Object> responseEntity = null;
			logger.info("list cleanup deleteProdOrder");
			for (int i = 0; i < order.getProducts().size(); i++) {
				if(!listCart.isEmpty()
						&& (order.getUserId()==listCart.get(0).getUserId()
						&& order.getDate().trim().equals(listCart.get(0).getDate().trim())))
				{				
					if(order.getProducts().get(i).getProductId()==listCart.get(0).getProducts().get(i).getProductId())
					{
						Long idTemp = order.getProducts().get(i).getProductId();							
						listCart.forEach(cart -> cart.getProducts().removeIf(product -> product.getProductId().equals(idTemp)));					
					}
				}	
			}		
			
			if(!listCart.isEmpty()
					&& (order.getUserId()==listCart.get(0).getUserId()
					&& order.getDate().trim().equals(listCart.get(0).getDate().trim())))
			{
				logger.info("completed successfully deleteProdOrder");
				return responseEntity.ok(listCart);
			}
			logger.info("do not generate content deleteProdOrder");
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			logger.info("ERROR ON getOrder {}",e);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("The service is unable to respond at the moment");
		}
		
	}

	@Override
	public ResponseEntity<Object> modProductCart(OrderDto order) {
		try {
			for (int i = 0; i < order.getProducts().size(); i++) {
				if(!listCart.isEmpty()
						&& (order.getUserId()==listCart.get(0).getUserId()
						&& order.getDate().trim().equals(listCart.get(0).getDate().trim())))
				{				
					if(order.getProducts().get(i).getProductId()==listCart.get(0).getProducts().get(i).getProductId())
					{
						Long idTemp = order.getProducts().get(i).getProductId();							
						listCart.forEach(cart -> cart.getProducts().removeIf(product -> product.getProductId().equals(idTemp)));						
						logger.info("LIST FILLING modProductCart {}",listCart.size());
					}
				}	
			}
			ResponseEntity<Object> responseEntity = null;			
			OrderDto cart = new OrderDto();		
			cart.setDate(order.getDate());
			cart.setUserId(order.getUserId());
			logger.info("LIST FILLING 2 modProductCart ");
			for (int i = 0; i < order.getProducts().size(); i++) {
				if(order.getProducts().get(i).getProductId()!=listCart.get(0).getProducts().get(i).getProductId())
				{
					ProductOrder prOrder = new ProductOrder();
					prOrder.setProductId(order.getProducts().get(i).getProductId());
					prOrder.setQuantity(order.getProducts().get(i).getQuantity());			
					Double price = order.getProducts().get(i).getQuantity() * order.getProducts().get(i).getPrice();
					prOrder.setPrice(price);			
					listProduct.add(prOrder);
				}
								
			}		
			cart.setProducts(listProduct);		
			listCart.add(cart);
			logger.info("completed successfully modProductCart");
			return responseEntity.ok(listCart);
		} catch (Exception e) {
			logger.info("ERROR ON modProductCart {}",e);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("The service is unable to respond at the moment");
		}		
		
	}

}
