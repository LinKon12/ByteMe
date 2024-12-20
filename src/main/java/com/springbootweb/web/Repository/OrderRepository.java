package com.springbootweb.web.Repository;

import com.springbootweb.web.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    Optional<Orders> findById(Long id);

}
