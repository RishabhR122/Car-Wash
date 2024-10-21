package com.Admin.model;

public class Transaction {
	
	private String transactionId;
    private String currency;
    private int amount;
    
    public Transaction() {}
    
    

    public Transaction(String transactionId, String currency, int amount) {
		super();
		this.transactionId = transactionId;
		this.currency = currency;
		this.amount = amount;
	}



	// Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
