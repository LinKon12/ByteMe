package com.springbootweb.web.Service;

import com.springbootweb.web.Entity.Item;
import com.springbootweb.web.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//ADMIN SIDE

@Service
public class MenuManagement {
    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item){
        return itemRepository.save(item);
    }
    public void removeItem(Long id){
        itemRepository.deleteById(id);
    }
    public Item updateItem(Long id,Item newItem){
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(newItem.getName());
        item.setDescription(newItem.getDescription());
        item.setPrice(newItem.getPrice());
        return itemRepository.save(newItem);
    }
    public List<Item> getAllMenuItems() {
        return itemRepository.findAll();
    }
}
