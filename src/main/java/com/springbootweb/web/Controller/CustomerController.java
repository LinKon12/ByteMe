package com.springbootweb.web.Controller;

import com.springbootweb.web.Entity.Customer;
import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Entity.Orders;
import com.springbootweb.web.Service.CustomerService;
import com.springbootweb.web.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MenuService menuService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/findByEmail")
    public Customer getCustomerByEmail(@RequestParam String email) {
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/menu/sortAsc")
    public List<Item> getItemsSortedByPriceAsc() {
        return menuService.getItemsSortedByPriceAsc();
    }

    @GetMapping("/menu/sortDesc")
    public List<Item> getItemsSortedByPriceDesc() {
        return menuService.getItemsSortedByPriceDesc();
    }
}
