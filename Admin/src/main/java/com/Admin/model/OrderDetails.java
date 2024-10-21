package com.Admin.model;

public class OrderDetails {
	
private String orderId;
	
	private String userName;

	private String userEmailId;
	
	private long userPhoneNo;
	
	private String areaPinCode;
	private String washerName;
	
	private String washerPack;
	private String status;

	
	
	Car cars;

	public OrderDetails() {

	}

	
	public OrderDetails(String orderId, String userName, String userEmailId, long userPhoneNo, String areaPinCode,
			String washerName, String washerPack, String status, Car cars) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.userEmailId = userEmailId;
		this.userPhoneNo = userPhoneNo;
		this.areaPinCode = areaPinCode;
		this.washerName = washerName;
		this.washerPack = washerPack;
		this.status = status;
		this.cars = cars;
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public long getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(long userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getAreaPinCode() {
		return areaPinCode;
	}

	public void setAreaPinCode(String areaPinCode) {
		this.areaPinCode = areaPinCode;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public String getWasherPack() {
		return washerPack;
	}

	public void setWasherPack(String washerPack) {
		this.washerPack = washerPack;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

}
