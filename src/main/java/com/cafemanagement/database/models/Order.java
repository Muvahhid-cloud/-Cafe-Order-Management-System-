package com.cafemanagement.database.models;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private String customerName;
    private double totalPrice;
    private String status;
    private LocalDateTime createdAt;

    public Order(int id, String customerName, double totalPrice, String status, LocalDateTime createdAt) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Order(String customerName, double totalPrice, String status) {
        this(0, customerName, totalPrice, status, LocalDateTime.now());
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
