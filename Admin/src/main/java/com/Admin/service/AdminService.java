package com.Admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Admin.model.Admin;
import com.Admin.model.Car;
import com.Admin.model.CustomerDetails;
import com.Admin.model.OrderDetails;
import com.Admin.model.Receipt;

@Service
public interface AdminService {
	
	public List<CustomerDetails> getAllCustomers();
	public CustomerDetails getCustomerById(String id);
	public List<Admin> getAllAdmins();
	public Admin findAdminById(String id);
	public void addAdmin(Admin admin);
	public void deleteAdmin(String id);
	public void updateAdmin(Admin admin);
	public void updateExistingCustomer(@RequestBody CustomerDetails customer);
	public void generateReceipt(Receipt receipt);
	public Receipt getReceiptbyId(int receiptId);
	public List<Car> allCarDetails();
	public void assignWasherName(OrderDetails order, String orderId);

}