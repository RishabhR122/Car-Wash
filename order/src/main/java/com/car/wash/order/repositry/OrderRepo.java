package com.car.wash.order.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.wash.order.model.OrderDetails;
@Repository
public interface OrderRepo extends JpaRepository<OrderDetails, String>{

}
