package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

public class kpop {
    private String name;
    private int imageId;
    private String price;

    public static final kpop[] kpops = {
            new kpop("Stickers", R.drawable.stickers,"10₪"),
            new kpop("Photocards", R.drawable.photocard,"12₪"),
            new kpop("Polaroid Photos", R.drawable.polaroid,"10₪"),
            new kpop("jungkook earings", R.drawable.jk,"18₪"),
            new kpop("BTS bag", R.drawable.bag,"30₪"),
            new kpop("Kawaii card holder", R.drawable.holder,"20₪"),
            new kpop("Twice Lomo Cards", R.drawable.lomo,"30₪"),
            new kpop("BT21 RJ mug", R.drawable.mug,"15₪"),
            new kpop("Sleepy BT21 Cushions", R.drawable.sleepy,"25₪"),
            new kpop("BT21 mini Cushions", R.drawable.bt21,"35₪"),
            new kpop("Photocard Album", R.drawable.album,"23₪")


    };

    public kpop(String name, int imageId, String price) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
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
