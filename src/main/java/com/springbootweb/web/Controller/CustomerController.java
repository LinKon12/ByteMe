package com.springbootweb.web.Controller;

import com.springbootweb.web.Entity.Cart;
import com.springbootweb.web.Entity.Customer;
import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Repository.CustomerRepository;
import com.springbootweb.web.Repository.ItemRepository;
import com.springbootweb.web.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuManagement menuManagement;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

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

    @GetMapping("/menu")
    public List<Item> getAllMenuItems() {
        return menuManagement.getAllMenuItems();
    }

    @GetMapping("/menu/search")
    public List<Item> getSearchedItem(@RequestParam String keyword) {
        return menuService.searchMenuItems(keyword);
    }

    @GetMapping("/menu/sortAsc")
    public List<Item> getItemsSortedByPriceAsc() {
        return menuService.getItemsSortedByPriceAsc();
    }

    @GetMapping("/menu/sortDesc")
    public List<Item> getItemsSortedByPriceDesc() {
        return menuService.getItemsSortedByPriceDesc();
    }

    @GetMapping("/cart/view")
    public ResponseEntity<List<Cart>> viewCart(@RequestParam Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);

        List<Cart> cartItems = cartService.viewCart(customer);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/cart/remove/{cartItemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok("Item removed from cart successfully!");
    }

    @GetMapping("/cart/total")
    public ResponseEntity<Double> calculateCartTotal(@RequestParam Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);

        double total = cartService.calculateCartTotal(customer);
        return ResponseEntity.ok(total);
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long customerId,
                                          @RequestParam Long itemId,
                                          @RequestParam int quantity) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));

        Cart cart = cartService.addToCart(customer, item, quantity);
        return ResponseEntity.ok(cart);
    }
}