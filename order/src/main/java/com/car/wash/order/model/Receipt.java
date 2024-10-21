package com.car.wash.order.model;

public class Receipt {
	
	private int receiptId;
	private int amount;
	String washPackName;
	
	public Receipt() {}
	
	
	

	public Receipt(int receiptId,int amount, String washPackName) {
		super();
		this.receiptId= receiptId;
		this.amount = amount;
		this.washPackName = washPackName;
	}




	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getWashPackName() {
		return washPackName;
	}
	public void setWashPackName(String washPackName) {
		this.washPackName = washPackName;
	}
	

}
