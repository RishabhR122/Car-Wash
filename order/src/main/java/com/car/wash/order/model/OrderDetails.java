package com.car.wash.order.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class OrderDetails {

	@Id
	private String orderId;
	
	private String userName;

	private String userEmailId;
	
	private long userPhoneNo;
	
	private String areaPinCode;
	private String washerName;
	
	private String washerPack;
	private String status;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	Car cars;

	public OrderDetails() {

	}

	public OrderDetails(String orderId, @NotEmpty(message = "Washer Name Can't be empty") String userName,
			@NotEmpty(message = "Email Can't be empty") String userEmailId,
			@NotEmpty(message = "Date can't be empty") long userPhoneNo,
			@NotEmpty(message = "Pincode can't be empty") String areaPinCode, String washerName,
			@NotEmpty(message = "Wash pack can't be empty") String washerPack, String status,
			@NotEmpty(message = "car field can't be empty") Car cars) {
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