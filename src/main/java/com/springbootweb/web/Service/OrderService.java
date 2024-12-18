package com.springbootweb.web.Service;

import com.springbootweb.web.Entity.Orders;
import com.springbootweb.web.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public String viewOrderStatus(Long orderId) {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        return "Order ID: " + orderId + ", Status: " + orders.getStatus();
    }
}

