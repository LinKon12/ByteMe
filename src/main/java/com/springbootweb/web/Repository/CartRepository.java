package com.springbootweb.web.Repository;

import com.springbootweb.web.Entity.Cart;
import com.springbootweb.web.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByCustomer(Customer customer);
}