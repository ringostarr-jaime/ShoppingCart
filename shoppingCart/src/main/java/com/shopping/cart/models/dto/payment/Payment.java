package com.shopping.cart.models.dto.payment;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class Payment {
	
	@NotNull(message = "userId may not be empty")
	private Long userId;
	@NotNull(message = "date may not be empty")
	private String date;
	@NotNull(message = "mount may not be empty")
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
