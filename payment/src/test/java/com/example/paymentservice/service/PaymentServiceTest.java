package com.example.paymentservice.service;

import com.example.paymentservice.entity.Transaction;
import com.example.paymentservice.repository.TransactionRepository;
import com.razorpay.Order;
import com.razorpay.OrderClient;
import com.razorpay.RazorpayClient;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @InjectMocks
    private PaymentServiceImpl paymentService;  // Inject the PaymentService which contains dependencies

    @Mock
    private TransactionRepository transactionRepository;  // Mock the TransactionRepository

    @Mock
    private RestTemplate restTemplate;  // Mock the RestTemplate

    @Mock
    private RazorpayClient razorpayClient;  // Mock the RazorpayClient

    @Mock
    private Order order;  // Mock the Order object

    @Mock
    private OrderClient orderClient;  // Mock the OrderClient which is used inside RazorpayClient

    @BeforeEach
    public void setup() throws Exception {
        // Initialize Mockito
        MockitoAnnotations.openMocks(this);

        // Mock RazorpayClient to return a mocked OrderClient when 'orders' is accessed
        when(razorpayClient.orders).thenReturn(orderClient);

        // Mock the creation of the order using the mocked OrderClient
        when(orderClient.create(any(JSONObject.class))).thenReturn(order);

        // Mock order details
        when(order.get("id")).thenReturn("order123");  // Mock the order ID
        when(order.get("currency")).thenReturn("INR");  // Mock the currency
        when(order.get("amount")).thenReturn(50000);  // Mock the amount (in paise)
    }

    @Test
    public void testCreateTransaction() throws Exception {
        // Create a mock transaction
        Transaction mockTransaction = new Transaction();
        mockTransaction.setTransactionId("order123");  // Set the order ID
        mockTransaction.setCurrency("INR");  // Set the currency
        mockTransaction.setAmount(50000);  // Set the amount (in paise)

        // Mock saving the transaction to the database
        when(transactionRepository.save(any(Transaction.class))).thenReturn(mockTransaction);

        // Mock RestTemplate's postForObject method to simulate calling another service
        when(restTemplate.postForObject(any(String.class), any(Transaction.class), any(Class.class)))
                .thenReturn("Success");

        // Test the createTransaction method in the PaymentService
        Transaction transaction = paymentService.createTransaction(500);  // Amount is in rupees, 500 * 100 = 50000 paise

        // Verify that the transaction is not null
        assertNotNull(transaction);
        // Verify that the order ID matches the mock
        assertEquals("order123", transaction.getTransactionId());
        // Verify that the currency matches the mock
        assertEquals("INR", transaction.getCurrency());
        // Verify that the amount matches the mock (50000 paise)
        assertEquals(50000, transaction.getAmount());

        // Verify that the transaction was saved to the repository
        verify(transactionRepository, times(1)).save(any(Transaction.class));

        // Verify that the RestTemplate called the other service
        verify(restTemplate, times(1)).postForObject(any(String.class), any(Transaction.class), any(Class.class));
    }
}
