package com.example.paymentservice.service;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.paymentservice.entity.Transaction;
import com.example.paymentservice.exceptions.TransactionNotFoundException;
import com.example.paymentservice.repository.TransactionRepository;
import com.razorpay.RazorpayClient;
import com.razorpay.Order;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.secret}")
    private String secret;

    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public Transaction createTransaction(int amount) {
        try {
        	
            RazorpayClient razorpayClient = new RazorpayClient(key, secret);
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100); // amount in paise
            orderRequest.put("currency", "INR");

            Order order = razorpayClient.orders.create(orderRequest);
            
            // Create and save transaction
            Transaction transaction = new Transaction();
            transaction.setTransactionId(order.get("id"));
            transaction.setCurrency(order.get("currency"));
            transaction.setAmount(amount);
            transactionRepository.save(transaction);
            
            
//            String response = restTemplate.postForObject("http://other-microservice/api/notify", transaction, String.class);
//            System.out.println("Response from other service: " + response);
//            
            return transaction;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String paymentSuccess(String transactionId) {
    	Optional<Transaction> op=transactionRepository.findById(transactionId);
    	if(op.isEmpty()) {
    		 throw new TransactionNotFoundException("Invalid Transaction");
    	}
    	
    	return "Payment of "+op.get().getAmount()+" is successfull";
    	
    }
	public int getTransactionAmount(String transactionId) {
		
		Optional<Transaction> op=transactionRepository.findById(transactionId);
    	if(op.isEmpty()) {
    		throw new TransactionNotFoundException("Invalid Transaction");
    	}
		return op.get().getAmount();
	}
}