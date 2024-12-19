package com.shopping.cart.models.dto.payment;

import java.util.UUID;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Payment {
	
	@NotNull(message = "userId may not be empty")
	@Min(value = 1, message = "the userId must be equal to or less than 1")
	@Max(value = 9999999, message = "the userId must be equal to or less than 9999999")
	private Long userId;
	@NotNull(message = "date may not be empty")
	private String date;
	@NotNull(message = "mount may not be empty")
	@DecimalMin(value =  "0.01", message = "the mount must be equal to or greater than 0.01") 
	@DecimalMax(value = "999999.99", message = "the mount must be equal to or less than 999999.99")
	private Double mount;
	
	private UUID idTransaction;
	private String comment;
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
	public Double getMount() {
		return mount;
	}
	public void setMount(Double mount) {
		this.mount = mount;
	}
	public UUID getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(UUID idTransaction) {
		this.idTransaction = idTransaction;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Payment [userId=" + userId + ", date=" + date + ", mount=" + mount + ", idTransaction=" + idTransaction
				+ ", comment=" + comment + "]";
	}
	

}
