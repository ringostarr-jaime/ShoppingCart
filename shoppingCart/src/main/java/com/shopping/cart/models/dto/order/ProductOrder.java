package com.shopping.cart.models.dto.order;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class ProductOrder {
	
	@Min(value = 1, message = "the productId must be equal to or greater than 1") 
	@Max(value = 999999, message = "the productId must be equal to or less than 999999")
	private Long productId;
	@Min(value = 1, message = "the quantity must be equal to or greater than 1") 
	@Max(value = 999999, message = "the quantity must be equal to or less than 100")
	private int quantity;
	@DecimalMin(value =  "0.01", message = "the value must be equal to or greater than 0.01") 
	@DecimalMax(value = "999999.99", message = "the value must be equal to or less than 999999.99")
	private Double price;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductOrder [productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
