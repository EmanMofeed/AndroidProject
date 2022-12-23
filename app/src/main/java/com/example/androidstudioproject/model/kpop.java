package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

public class kpop {
    private String name;
    private int imageId;
    private double price;
    private int quantity ;
    private String cate;
    private String description;

    public static final kpop[] kpops = {
            new kpop("Stickers", R.drawable.stickers,10,1,"kpop","10 pieces medium size stickers"),
            new kpop("Photocards", R.drawable.photocard,12,1,"kpop","8 pieces of photocard"),
            new kpop("Polaroid Photos", R.drawable.polaroid,10,1,"kpop","10 pieces of polaroid photos"),
            new kpop("jungkook earings", R.drawable.jk,18,1,"kpop","2 pieces of jungkook earings"),
            new kpop("BTS bag", R.drawable.bag,30,1,"kpop","1 piece bts backpack"),
            new kpop("Kawaii card holder", R.drawable.holder,20,1,"kpop","1 piece photocard holder"),
            new kpop("Twice Lomo Cards", R.drawable.lomo,30,1,"kpop","55 pieces of twice cards"),
            new kpop("BT21 RJ mug", R.drawable.mug,15,1,"kpop","1 piece bt21 rj mug"),
            new kpop("Sleepy BT21 Cushions", R.drawable.sleepy,25,1,"kpop","1 random piece of bt21 cushions"),
            new kpop("BT21 mini Cushions", R.drawable.bt21,35,1,"kpop","1 random piece of bt21 cushions"),
            new kpop("Photocard Album", R.drawable.album,23,1,"kpop"," piece of photocards album,44 pocket")

    };

    public kpop(String name, int imageId, double price,int quantity,String cate,String description) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
        this.cate = cate;
        this.description =description;
    }

    public kpop(String name, int imageId, double price,String description) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
        this.description =description;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
}