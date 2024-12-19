package com.shopping.cart.models.dto.order;

import java.util.List;

import com.shopping.cart.models.dto.product.ProductId;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class DeleteOrderDto extends ClientDto{

	@Valid
	@NotEmpty(message = "products may not be empty")
	private List<ProductId> products;

	public List<ProductId> getProducts() {
		return products;
	}

	public void setProducts(List<ProductId> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "DeleteOrderDto [products=" + products + "]";
	}
	
	
	
}
