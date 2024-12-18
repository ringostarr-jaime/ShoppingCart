package com.shopping.cart.models.dto.order;

public class ProductOrder {
	
	private Long productId; 
	private int quantity;
	private double price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductOrder [productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
	}
	

	
}
