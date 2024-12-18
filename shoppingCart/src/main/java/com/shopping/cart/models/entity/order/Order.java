package com.shopping.cart.models.entity.order;

import java.time.LocalDateTime;
import java.util.List;

import com.shopping.cart.models.entity.client.Client;

public class Order {

	private Client client; 	 
	private LocalDateTime orderDate; 
	private List<OrderDetail> orderDetails; 
	private double totalAmount; 
	private String orderStatus; 
	private String shippingAddress; 
	private String billingAddress;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	@Override
	public String toString() {
		return "Order [client=" + client + ", orderDate=" + orderDate + ", orderDetails=" + orderDetails
				+ ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus + ", shippingAddress="
				+ shippingAddress + ", billingAddress=" + billingAddress + "]";
	}
	
}
