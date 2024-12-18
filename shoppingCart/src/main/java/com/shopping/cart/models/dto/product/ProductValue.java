package com.shopping.cart.models.dto.product;

import jakarta.validation.constraints.NotEmpty;


public class ProductValue {
	
	@NotEmpty(message = "value may not be empty")    
    private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "RequestProduct [value=" + value + "]";
	}
}
