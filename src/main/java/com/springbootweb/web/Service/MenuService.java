package com.springbootweb.web.Service;

import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// CUSTOMER SIDE
@Service
public class MenuService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> searchMenuItems(String keyword) {
        return itemRepository.findByName(keyword);
    }

    public List<Item> filterByCategory(String category) {
        return itemRepository.findByCategory(category);
    }
    public List<Item> getItemsSortedByPriceAsc(){
        return itemRepository.findAllByOrderByPriceAsc();
    }
    public List<Item> getItemsSortedByPriceDesc() {
        return itemRepository.findAllByOrderByPriceDesc();
    }
}
