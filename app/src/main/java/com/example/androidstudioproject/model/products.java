package com.example.androidstudioproject.model;

import android.graphics.drawable.Drawable;

public class products {
    private String cat;
    private String productName;
    private String desc;
    private Double price;
    private int img;

    public products() {
    }

    public products(String cat, String productName, String desc, Double price, int img) {
        this.cat = cat;
        this.productName = productName;
        this.desc = desc;
        this.price = price;
        this.img = img;
    }

    public String getCat() {
        return cat;
    }

    public String getProductName() {
        return productName;
    }

    public String getDesc() {
        return desc;
    }

    public Double getPrice() {return price;}

    public int getImg() {return img;}

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImg(int img) { this.img = img; }
}
