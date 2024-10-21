package com.customer.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.exception.CustomerAlreadyExistException;
import com.customer.exception.CustomerDoNotExistException;
import com.customer.model.CustomerDetails;
import com.customer.model.OrderDetails;
import com.customer.model.Ratings;
import com.customer.model.Receipt;
import com.customer.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	RestTemplate restTemplate;

	static final String url = "http://localhost:8080/admin";

	public List<CustomerDetails> findAllCustomers() {

		return customerRepo.findAll();
	}

	public CustomerDetails findCustomersById(String id) {
		Optional<CustomerDetails> op = customerRepo.findById(id);
		if (op.isEmpty()) {
			throw new CustomerDoNotExistException("No customer of id:" + id + " exists");
		}
		return op.get();
	}

	public void addCustomer(CustomerDetails customer) {
		Optional<CustomerDetails> op = customerRepo.findById(customer.getId());
		if (!op.isEmpty()) {
			throw new CustomerAlreadyExistException("Customer of id:" + customer.getId() + " already exists");
		} else {
			customerRepo.save(customer);
		}

	}

	public void deleteCustomer(String id) {
		Optional<CustomerDetails> op = customerRepo.findById(id);
		if (op.isEmpty()) {
			throw new CustomerDoNotExistException("Customer not found");
		} else {
			customerRepo.deleteById(id);
		}
	}

	public void updateCustomer(CustomerDetails customer) {
		Optional<CustomerDetails> op = customerRepo.findById(customer.getId());
		if (op.isEmpty()) {
			throw new CustomerDoNotExistException("No customer of id:" + customer.getId() + " exists");
		} else {
			customerRepo.save(customer);
		}

	}
	
	public Receipt getReceiptbyId(int receiptId) {
		
		Receipt receipt=restTemplate.getForObject(url+"/getReceipt/"+receiptId, Receipt.class);
		return receipt;
	}
	
	public List<Ratings> getSpecificWasherRating(String washerName) {

		Ratings[] ratings=restTemplate.getForObject(url+"/washerSpecificRating/"+washerName, Ratings[].class);
		return Arrays.asList(ratings);

	}
	
	

}
