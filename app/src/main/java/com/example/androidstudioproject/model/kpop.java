package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

public class kpop {
    private String name;
    private int imageId;
    private String price;
    private int quantity ;
    private String cate;

    public static final kpop[] kpops = {
            new kpop("Stickers", R.drawable.stickers,"10₪",1,"kpop"),
            new kpop("Photocards", R.drawable.photocard,"12₪",1,"kpop"),
            new kpop("Polaroid Photos", R.drawable.polaroid,"10₪",1,"kpop"),
            new kpop("jungkook earings", R.drawable.jk,"18₪",1,"kpop"),
            new kpop("BTS bag", R.drawable.bag,"30₪",1,"kpop"),
            new kpop("Kawaii card holder", R.drawable.holder,"20₪",1,"kpop"),
            new kpop("Twice Lomo Cards", R.drawable.lomo,"30₪",1,"kpop"),
            new kpop("BT21 RJ mug", R.drawable.mug,"15₪",1,"kpop"),
            new kpop("Sleepy BT21 Cushions", R.drawable.sleepy,"25₪",1,"kpop"),
            new kpop("BT21 mini Cushions", R.drawable.bt21,"35₪",1,"kpop"),
            new kpop("Photocard Album", R.drawable.album,"23₪",1,"kpop")

    };

    public kpop(String name, int imageId, String price,int quantity,String cate) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
        this.cate = cate;
    }

    public kpop(String name, int imageId, String price) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getPrice() {
        return price;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
}