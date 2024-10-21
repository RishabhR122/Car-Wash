package com.example.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PaymentserviceApplication {
	 @Bean
   public RestTemplate restTemplate() {
       return new RestTemplate();
   }

	public static void main(String[] args) {
		SpringApplication.run(PaymentserviceApplication.class, args);
		System.out.println("Spring is working");
		
		
	}

}
