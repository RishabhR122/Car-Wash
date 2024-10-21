package com.customer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.model.OrderDetails;
import com.customer.model.Ratings;
import com.customer.model.WashPacks;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	static final String url1="http://localhost:8080/admin";
	static final String url2="http://localhost:8080/orders";

	
	 
	//To see all the WashPacks
	    public List<WashPacks> getAllWP(){
	        WashPacks[] wp=restTemplate.getForObject(url1+"/all/findWP",WashPacks[].class);
	        return (Arrays.asList(wp));
	    }
	    
	    public WashPacks getWPByID(String id) {
	    	WashPacks wp=restTemplate.getForObject(url1+"/all/findWP/"+id, WashPacks.class);
	    	return wp;
	    }
	    
	    public void placeOrder(OrderDetails orderDetails) {
	    	restTemplate.postForLocation(url2+"/placeOrder",orderDetails);
	    }
	    
	    public List<OrderDetails> seeMyOrders(String customerName){
			
			OrderDetails[] orders=restTemplate.getForObject(url2+"/findMyOrder/"+customerName, OrderDetails[].class);
			return Arrays.asList(orders);
		}
	    
	   public void addRatingToWasher(String email, Ratings rating){
		   restTemplate.postForLocation(url1+"/washer/addRating/"+email, rating);
	   }
	   
	   public void cancelOrder(OrderDetails order) {
		   restTemplate.put(url2+"/cancelOrder", order);
	   }

}
