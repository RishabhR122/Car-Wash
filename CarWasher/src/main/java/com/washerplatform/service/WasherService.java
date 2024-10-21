package com.washerplatform.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.washerplatform.models.OrderDetails;

@Service
public class WasherService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	String url="http://localhost:8080/orders/";
	
	
	public List<OrderDetails> getUnassignedOrders(){
        OrderDetails[] unassignedList = restTemplate.getForObject(url+"findUnassignedOrders",OrderDetails[].class);
        return Arrays.asList(unassignedList);
    }
    //To update the status of the order by Washer
    public OrderDetails updateStatus(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        OrderDetails od = restTemplate.exchange(url+"update/"+orderDetails.getOrderId(), HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
        return od;
    }
    //To assign a washer to the order by washer
    public OrderDetails assignSelf(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails,headers);
        OrderDetails od = restTemplate.exchange(url+"assignWasherName/"+orderDetails.getOrderId(), HttpMethod.PUT,assignedWasher,OrderDetails.class).getBody();
        return od;
    }
}
