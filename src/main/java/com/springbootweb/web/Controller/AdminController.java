package com.springbootweb.web.Controller;

import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Entity.Orders;
import com.springbootweb.web.Service.MenuManagement;
import com.springbootweb.web.Service.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MenuManagement menuManagement;

    @Autowired
    private OrderManagement orderManagement;
    @GetMapping("/menu")
    public List<Item> getAllMenuItems() {
        return menuManagement.getAllMenuItems();
    }
    @PostMapping("/menu")
    public Item addItem(@RequestBody Item item) {
        return menuManagement.addItem(item);
    }
    @PutMapping("/menu/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return menuManagement.updateItem(id, item);
    }
    @DeleteMapping("/menu/{id}")
    public void removeItem(@PathVariable Long id) {
        menuManagement.removeItem(id);
    }

    @GetMapping("/orders/pending")
    public List<Orders> getPendingOrders() {
        return orderManagement.getPendingOrders();
    }

    @PutMapping("/orders/{id}/status")
    public Orders updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return orderManagement.updateOrderStatus(id, status);
    }
}
