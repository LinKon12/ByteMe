package com.springbootweb.web.Service;

import com.springbootweb.web.Entity.Orders;
import com.springbootweb.web.Repository.OrderRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//ADMIN SIDE

@Service
public class OrderManagement {
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getPendingOrders() {
        List<Orders> allOrders = orderRepository.findAll();
        ArrayList<Orders> pendingOrders = new ArrayList<>();

        for (Orders order : allOrders) {
            if ("Pending".equals(order.getStatus())) {
                pendingOrders.add(order);
            }
        }
        Collections.sort(pendingOrders, new Comparator<Orders>() {
            @Override
            public int compare(Orders o1, Orders o2) {
                return Boolean.compare(o2.isVIP(), o1.isVIP());
            }
        });
        return pendingOrders;
    }

    public List<Orders> getSpecialRequestOrders() {
        List<Orders> allOrders = orderRepository.findAll();
        ArrayList<Orders> specialRequestOrders = new ArrayList<>();
        for (Orders orders : allOrders) {
            if (orders.getSpecialRequest() != null) {
                specialRequestOrders.add(orders);
            }
        }
        return specialRequestOrders;
    }

    public Orders updateOrderStatus(Long id, String status) {
        Orders order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
    // process refund
}
