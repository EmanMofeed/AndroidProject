package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

public class anime {
    private String name;
    private int imageId;
    private double price;
    private int quantity ;
    private String cate;
    private String description;


    public static final anime[] animes = {
            new anime("Attack on Titans necklace", R.drawable.aot,15,1,"anime","1 piece of attack on titans necklace"),
            new anime("Naruto figuers", R.drawable.naruto,15,1,"anime","1 piece random figure"),
            new anime("Zoro earings", R.drawable.zoro,15,1,"anime","3 pieces zoro earings"),
            new anime("attack on titans mug", R.drawable.aotmug,15,1,"anime","1 piece cup"),
            new anime("Naruto phone cases", R.drawable.covers,30,1,"anime","1 piece Iphone 13 pro max case"),
            new anime("Demon Slayer Keychains", R.drawable.dkey,6,1,"anime","1 piece small keychain"),
            new anime("Demon Slayer figuers", R.drawable.demon,15,1,"anime","1 piece random figure"),
            new anime("Posters", R.drawable.posters,8,1,"anime","1 piece A4 poster"),
            new anime("Spy X Family lomocards", R.drawable.spylomo,18,1,"anime","1 piece A4 poster")

    };

    public anime(String name, int imageId, double price,int quantity, String cate,String description) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
        this.cate = cate;
        this.description = description;

    }

    public anime(String name, int imageId, double price,String description) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
        this.description = description;

    }
    public anime(String name, int imageId, double price,int quantity,String description) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
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

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
