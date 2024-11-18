package com.springbootweb.web.Entity;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Item menuItem;

    private int quantity;

    public Cart(Long id, Customer customer, Item menuItem, int quantity) {
        this.id = id;
        this.customer = customer;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Item menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}