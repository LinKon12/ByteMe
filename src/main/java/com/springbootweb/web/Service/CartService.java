package com.springbootweb.web.Service;

import com.springbootweb.web.Entity.Cart;
import com.springbootweb.web.Entity.Customer;
import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//CUSTOMER SIDE

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

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
}
