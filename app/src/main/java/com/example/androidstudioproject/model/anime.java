package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

public class anime {
    private String name;
    private String image;
    private double price;
    private int quantity ;
    private String cate;
    private String description;

    public anime(String name, String imageURL, String desc, double price, String type) {
        this.name = name;
        this.image = imageURL;
        this.price = price;
        this.cate = type;
        this.description = desc;

    }

    public anime(String name, String imageId, double price,int quantity,String description) {
        this.name = name;
        this.image = imageId;
        this.price = price;
        this.quantity=quantity;
        this.description = description;


    }
    public anime() {


    }
    public anime(String name, String imageId, double price,int quantity) {
        this.name = name;
        this.image = imageId;
        this.price = price;
        this.quantity=quantity;
        this.description = description;


    }

    public anime(String image, String name, double price) {
        this.price = price;
        this.name=name;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public void setImageId(String imageId) {
        this.image = imageId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calcTotalPrice(int quantity,double price){
        double total=quantity*price;
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
