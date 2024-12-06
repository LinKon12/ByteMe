package com.springbootweb.web.Entity;

import jakarta.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item item;
    @ManyToOne
    private Customer customer;

    private String status;
    private String specialRequest;
    private boolean isVIP;

    public Orders(Long id, Item item, String status, boolean isVIP, String specialRequest) {
        this.id = id;
        this.item = item;
        this.status = status;
        this.isVIP = isVIP;
        this.specialRequest = specialRequest;
    }

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVIP() {
        return isVIP;
    }
    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}

