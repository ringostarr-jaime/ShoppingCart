package com.shopping.cart.models.dto.product;

import jakarta.validation.constraints.NotNull;

public class ProductId {
	@NotNull(message = "productId may not be empty")
    private Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductId [productId=" + productId + "]";
	}
	
}
