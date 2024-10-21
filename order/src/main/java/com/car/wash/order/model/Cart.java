package com.car.wash.order.model;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class Cart {
	private int cartId;
	private String orderId;
	private String userEmailId;
	private List<Items> items;
	private Car car;
	private String washPacks;
	private int totalPrice;
	@NotEmpty(message = "phoneNo can't be empty")
	private long phoneNo;
	@NotEmpty(message = "Pincode can't be empty")
	private String areaPinCode;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Cart(int cartId, String orderId, String userEmailId, List<Items> items, Car car, String washPacks,
//			int totalPrice, long phoneNo, String areaPinCode) {
//		super();
//		this.cartId = cartId;
//		this.orderId = orderId;
//		this.userEmailId = userEmailId;
//		this.items = items;
//		this.car = car;
//		this.washPacks = washPacks;
//		this.totalPrice = totalPrice;
//		this.phoneNo = phoneNo;
//		this.areaPinCode = areaPinCode;
//	}
	
	
	
	public Cart(int cartId, String orderId, String userEmailId, List<Items> items, Car car, String washPacks,
		int totalPrice, @NotEmpty(message = "phoneNo can't be empty") long phoneNo,
		@NotEmpty(message = "Pincode can't be empty") String areaPinCode) {
	super();
	this.cartId = cartId;
	this.orderId = orderId;
	this.userEmailId = userEmailId;
	this.items = items;
	this.car = car;
	this.washPacks = washPacks;
	this.totalPrice = totalPrice;
	this.phoneNo = phoneNo;
	this.areaPinCode = areaPinCode;
}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getWashPacks() {
		return washPacks;
	}
	public void setWashPacks(String washPacks) {
		this.washPacks = washPacks;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAreaPinCode() {
		return areaPinCode;
	}
	public void setAreaPinCode(String areaPinCode) {
		this.areaPinCode = areaPinCode;
	}
//	@Override
//	public String toString() {
//		return "Cart [cartId=" + cartId + ", orderId=" + orderId + ", userEmailId=" + userEmailId + ", items=" + items
//				+ ", car=" + car + ", washPacks=" + washPacks + ", totalPrice=" + totalPrice + ", phoneNo=" + phoneNo
//				+ ", areaPinCode=" + areaPinCode + "]";
//	}



	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", orderId=" + orderId + ", userEmailId=" + userEmailId + ", items=" + items
				+ ", car=" + car + ", washPacks=" + washPacks + ", totalPrice=" + totalPrice + ", phoneNo=" + phoneNo
				+ ", areaPinCode=" + areaPinCode + "]";
	}
	
	
	
	
}
