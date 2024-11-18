package com.springbootweb.web.Repository;

import com.springbootweb.web.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
