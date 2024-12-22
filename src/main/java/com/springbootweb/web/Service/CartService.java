package com.springbootweb.web.Service;

import com.springbootweb.web.Entity.Cart;
import com.springbootweb.web.Entity.Customer;
import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Entity.Orders;
import com.springbootweb.web.Repository.CartRepository;
import com.springbootweb.web.Repository.OrderRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//CUSTOMER SIDE

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    public Cart addToCart(Customer customer, Item menuItem, int quantity) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setMenuItem(menuItem);
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public List<Cart> viewCart(Customer customer) {
        return cartRepository.findByCustomer(customer);
    }

    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    public double calculateCartTotal(Customer customer) {
        return cartRepository.findByCustomer(customer).stream()
                .mapToDouble(cart -> cart.getMenuItem().getPrice() * cart.getQuantity())
                .sum();
    }

    //todo: implement modify
    public String placeOrder(Customer customer) {
        List<Cart> cartItems = cartRepository.findByCustomer(customer);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty. Cannot place order.");
        }
        for (Cart cart : cartItems) {
            Orders orders = new Orders();
            orders.setCustomer(cart.getCustomer());
            orders.setItem(cart.getMenuItem());
            orders.setQuantity(cart.getQuantity());
            orders.setStatus("Placed");
            orderRepository.save(orders);
        }
        cartRepository.deleteAll(cartItems);

        return "Order placed successfully!";
    }

}
