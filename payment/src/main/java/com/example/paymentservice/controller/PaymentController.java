package com.example.paymentservice.controller;

import com.example.paymentservice.entity.Transaction;
import com.example.paymentservice.service.PaymentService;
import com.example.paymentservice.service.PaymentServiceImpl;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Validated
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create/{cartId}")
    public ResponseEntity<Transaction> createTransaction(@Valid @PathVariable int cartId) {
    	Integer amount=restTemplate.getForObject("http://localhost:8080/cart/getTotalPrice/"+cartId, Integer.class);
        Transaction transaction = paymentService.createTransaction(amount);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/success/{id}")
    public String sendSuccesConfirmation(@PathVariable String id) {
    	
    	return paymentService.paymentSuccess(id);
    }
    @GetMapping("/getAmount/{id}")
    public int getTransactionAmount(@PathVariable String id) {
    	
    	return paymentService.getTransactionAmount(id);
    }
}
