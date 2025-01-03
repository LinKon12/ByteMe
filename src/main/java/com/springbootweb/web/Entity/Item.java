package com.springbootweb.web.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Item {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;
private String name;
private Double price;
private String category;
private String description;

    public Item(long id, String name, Double price, String category, String description) {
        Id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public Item() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
