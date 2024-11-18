package com.springbootweb.web.Service;

import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuService {
    @Autowired
    private ItemRepository itemRepository;
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
    public List<Item> searchMenuItems(String keyword) {
        return itemRepository.findByName(keyword);
    }
    public List<Item> filterByCategory(String category) {
        return itemRepository.findByCategory(category);
    }
}
