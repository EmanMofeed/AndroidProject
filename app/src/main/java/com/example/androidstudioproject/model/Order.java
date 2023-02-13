package com.example.androidstudioproject.model;

import java.util.Random;

public class Order {
    private int orderId;
    private String orderDate;
    private double orderAmount;
    private String city;


    public Order(int orderId, String orderDate, double orderAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;

    }

    public Order( String orderDate, double orderAmount, String city) {
        setOrderId();
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.city = city;
    }



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId() {
        Random random = new Random();
        int randomNumber = random.nextInt(100-1) + 1;
        this.orderId = randomNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
