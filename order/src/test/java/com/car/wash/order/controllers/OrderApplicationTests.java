package com.car.wash.order.controllers;

import com.car.wash.order.model.OrderDetails;
import com.car.wash.order.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    private OrderDetails orderDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderDetails = new OrderDetails(); // Initialize with test data if needed
    }
    OrderDetails ord = new OrderDetails();

    @Test
    void testGetAllDetails() {
        // Arrange
        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
        when(orderService.allDetails()).thenReturn(orderList);

        // Act
        List<OrderDetails> result = orderController.getAllDetails();

        // Assert
        assertEquals(orderList, result);
        verify(orderService, times(1)).allDetails();
    }

//    @Test
//    void testAddAllData() {
//        // Arrange
//        OrderDetails orderDetails = new OrderDetails(); // Initialize with appropriate test data if needed
//        doNothing().when(orderService).addData(any(OrderDetails.class));
//
//        // Act
//        String result = orderController.addAllData(orderDetails);
//
//        // Assert
//        assertEquals("details saved", result);
//        verify(orderService, times(1)).addData(orderDetails);
//    }

    @Test
    void testOrderPlace() {
        // Arrange
        when(orderService.addOrder(any(OrderDetails.class))).thenReturn(orderDetails);

        // Act
        OrderDetails result = orderController.orderPlace(orderDetails);

        // Assert
        assertEquals(orderDetails, result);
        verify(orderService, times(1)).addOrder(orderDetails);
    }

//    @Test
//    void testCancelOrder() {
//        // Arrange
//        doNothing().when(orderService).cancelOrder(any(OrderDetails.class));
//
//        // Act
//        String result = orderController.cancelOrder(orderDetails);
//
//        // Assert
//        assertEquals("The order with ID - null is cancelled Successfully.", result);
//        verify(orderService, times(1)).cancelOrder(orderDetails);
//    }

    @Test
    void testGetDetailsByEmailId() {
        // Arrange
        String emailId = "test@example.com";
        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
        when(orderService.getOrdersOnUserEmailId(emailId)).thenReturn(orderList);

        // Act
        List<OrderDetails> result = orderController.getDetailsByEmailId(emailId);

        // Assert
        assertEquals(orderList, result);
        verify(orderService, times(1)).getOrdersOnUserEmailId(emailId);
    }

//    @Test
//    void testAllCompletedOrders() {
//        // Arrange
//        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
//        when(orderService.getAllCompletedOrders()).thenReturn(orderList);
//
//        // Act
//        List<OrderDetails> result = orderController.allCompletedOrders();
//
//        // Assert
//        assertEquals(orderList, result);
//        verify(orderService, times(1)).getAllCompletedOrders();
//    }

    @Test
    void testAllPendingOrders() {
        // Arrange
        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
        when(orderService.getAllPendingOrders()).thenReturn(orderList);

        // Act
        List<OrderDetails> result = orderController.allPendingOrders();

        // Assert
        assertEquals(orderList, result);
        verify(orderService, times(1)).getAllPendingOrders();
    }

    @Test
    void testAllCancelledOrders() {
        // Arrange
        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
        when(orderService.getAllCancelledOrders()).thenReturn(orderList);

        // Act
        List<OrderDetails> result = orderController.allCancelledOrders();

        // Assert
        assertEquals(orderList, result);
        verify(orderService, times(1)).getAllCancelledOrders();
    }

    @Test
    void testAllUnassignedOrders() {
        // Arrange
        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
        when(orderService.getAllAssignedOrders()).thenReturn(orderList);

        // Act
        List<OrderDetails> result = orderController.allUnassignedOrders();

        // Assert
        assertEquals(orderList, result);
        verify(orderService, times(1)).getAllAssignedOrders();
    }

    @Test
    void testAllOrderSpecificWashers() {
        // Arrange
        String washerName = ord.getWasherName();
        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
        when(orderService.getOrdersBySpecificWasher(washerName)).thenReturn(orderList);

        // Act
        List<OrderDetails> result = orderController.allOrderSpecificWashers(washerName);

        // Assert
        assertEquals(orderList, result);
        verify(orderService, times(1)).getOrdersBySpecificWasher(washerName);
    }

    @Test
    void testAllOrdersBySpecificUser() {
        // Arrange
    
        String userName = ord.getUserName();
        List<OrderDetails> orderList = Collections.singletonList(orderDetails);
        when(orderService.getOrdersBySpecificUsers(userName)).thenReturn(orderList);

        // Act
        List<OrderDetails> result = orderController.allOrdersBySpecificUser(userName);

        // Assert
        assertEquals(orderList, result);
        verify(orderService, times(1)).getOrdersBySpecificUsers(userName);
    }

//    @Test
//    void testAllOrdersByOrderId() {
//        // Arrange
//        String orderId = "123";
//        Optional<OrderDetails> optionalOrderDetails = Optional.of(orderDetails);
//        when(orderService.getOneOrder(orderId)).thenReturn(optionalOrderDetails);
//
//        // Act
//        ResponseEntity<Optional<OrderDetails>> result = orderController.allOrdersByOrderId(orderId);
//
//        // Assert
//        assertEquals(optionalOrderDetails, result.getBody());
//        verify(orderService, times(1)).getOneOrder(orderId);
//    }

    @Test
    void testDeletedOrder() {
        // Arrange
        String orderId = ord.getOrderId();
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        when(orderService.deleteOrder(orderId)).thenReturn(ResponseEntity.ok(response));

        // Act
        ResponseEntity<Map<String, Boolean>> result = orderController.deletedOrder(orderId);

        // Assert
        assertEquals(response, result.getBody());
        verify(orderService, times(1)).deleteOrder(orderId);
    }

    @Test
    void testCancelOrderById() {
        // Arrange
        String orderId = ord.getOrderId();
        when(orderService.cancelOrderWithId(orderId)).thenReturn(ResponseEntity.ok(orderDetails));

        // Act
        ResponseEntity<OrderDetails> result = orderController.cancelOrderById(orderId);

        // Assert
        assertEquals(orderDetails, result.getBody());
        verify(orderService, times(1)).cancelOrderWithId(orderId);
    }

    @Test
    void testUpdateOrderStatus() {
        // Arrange
        String orderId = ord.getOrderId();
        when(orderService.updateStatus(orderId)).thenReturn(ResponseEntity.ok(orderDetails));

        // Act
        ResponseEntity<OrderDetails> result = orderController.updateOrderStatus(orderId);

        // Assert
        assertEquals(orderDetails, result.getBody());
        verify(orderService, times(1)).updateStatus(orderId);
    }

//    @Test
//    void testAddWasherName() {
//        // Arrange
//        String orderId = ord.getOrderId();
//        when(orderService.assignWasherName(any(OrderDetails.class), anyString())).thenReturn(orderDetails);
//
//        // Act
//        OrderDetails result = orderController.addWasherName(orderDetails, orderId);
//
//        // Assert
//        assertEquals(orderDetails, result);
//        verify(orderService, times(1)).assignWasherName(orderDetails, orderId);
//    }
}
