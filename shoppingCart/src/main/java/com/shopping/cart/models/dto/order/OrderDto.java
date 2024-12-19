package com.shopping.cart.models.dto.order;

import java.util.List;

import jakarta.validation.Valid;

public class OrderDto extends ClientDto{
	
	@Valid
	private List<ProductOrder> products;

	public List<ProductOrder> getProducts() {
		return products;
	}

	public void setProducts(List<ProductOrder> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + ", getUserId()=" + getUserId() + ", getDate()=" + getDate()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
}
