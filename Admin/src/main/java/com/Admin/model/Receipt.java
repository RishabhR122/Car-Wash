package com.Admin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
public class Receipt {
	
	@Id
	private int receiptId;
	@Positive(message = "Cost Should be positive")
	private int amount;
	
	@NotEmpty(message="Detail cannot be left empty")
	String washPackName;
	
	public Receipt() {}

	public Receipt(int receiptId, @Positive(message = "Cost Should be positive") int amount,
			@NotEmpty(message = "Detail cannot be left empty") String washPackName) {
		super();
		this.receiptId = receiptId;
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