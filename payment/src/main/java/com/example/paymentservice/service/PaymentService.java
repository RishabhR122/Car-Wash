package com.example.paymentservice.service;

import com.example.paymentservice.entity.Transaction;

public interface PaymentService {
	
	 public Transaction createTransaction(int amount);
	 public String paymentSuccess(String transactionId);
	 public int getTransactionAmount(String transactionId);

}
