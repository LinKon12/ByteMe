package com.springbootweb.web.Repository;

import com.springbootweb.web.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByName(String keyword);
    List<Item> findByCategory(String category);

}
