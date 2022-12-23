package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

public class kpop {
    private String name;
    private int imageId;
    private String price;
    private int quantity ;

    public static final kpop[] kpops = {
            new kpop("Stickers", R.drawable.stickers,"10₪",1),
            new kpop("Photocards", R.drawable.photocard,"12₪",1),
            new kpop("Polaroid Photos", R.drawable.polaroid,"10₪",1),
            new kpop("jungkook earings", R.drawable.jk,"18₪",1),
            new kpop("BTS bag", R.drawable.bag,"30₪",1),
            new kpop("Kawaii card holder", R.drawable.holder,"20₪",1),
            new kpop("Twice Lomo Cards", R.drawable.lomo,"30₪",1),
            new kpop("BT21 RJ mug", R.drawable.mug,"15₪",1),
            new kpop("Sleepy BT21 Cushions", R.drawable.sleepy,"25₪",1),
            new kpop("BT21 mini Cushions", R.drawable.bt21,"35₪",1),
            new kpop("Photocard Album", R.drawable.album,"23₪",1)


    };

    public kpop(String name, int imageId, String price,int quantity) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
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
}