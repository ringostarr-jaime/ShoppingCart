package com.shopping.cart.models.dto.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class ClientDto {
	
	@NotNull(message = "userId may not be empty")
	private Long userId;
	@NotEmpty(message = "date may not be empty")
	private String date;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CartUser [userId=" + userId + ", date=" + date + "]";
	} 
	
	
}
