package com.shopping.cart.models.dto.product;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProductId {
	
	@NotNull(message = "productId may not be empty")
	@Min(value = 1, message = "the productId must be equal to or less than 1")
	@Max(value = 9999999, message = "the productId must be equal to or less than 9999999")
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
