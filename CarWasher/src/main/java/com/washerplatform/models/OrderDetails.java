package com.washerplatform.models;

import jakarta.persistence.Id;



public class OrderDetails {
	@Id
	private String orderId;
	private String usermailId;
	private String washerName;
    private String washpacks;
    private long phoneNo;
    private String areapincode;
    private String status;
    private Car cars;
	public OrderDetails() {
		
	}
	 public OrderDetails(String orderId, String useremailid, String washerName, String washpack, long phoneNo, String areapincode, String status, Car cars) {
	        this.orderId = orderId;
	        this.usermailId = useremailid;
	        this.washerName = washerName;
	        this.washpacks = washpack;
	        this.phoneNo = phoneNo;
	        this.areapincode = areapincode;
	        this.status = status;
	        this.cars = cars;
	    }
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUsermailId() {
		return usermailId;
	}
	public void setUsermailId(String usermailId) {
		this.usermailId = usermailId;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public String getWashpacks() {
		return washpacks;
	}
	public void setWashpacks(String washpacks) {
		this.washpacks = washpacks;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAreapincode() {
		return areapincode;
	}
	public void setAreapincode(String areapincode) {
		this.areapincode = areapincode;
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
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", usermailId=" + usermailId + ", washerName=" + washerName
				+ ", washpacks=" + washpacks + ", phoneNo=" + phoneNo + ", areapincode=" + areapincode + ", status="
				+ status + ", cars=" + cars + "]";
	}
	 
}
