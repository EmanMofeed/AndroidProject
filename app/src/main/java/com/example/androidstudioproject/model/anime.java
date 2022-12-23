package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

public class anime {
    private String name;
    private int imageId;
    private String price;
    private int quantity ;

    public static final anime[] animes = {
            new anime("Attack on Titans necklace", R.drawable.aot,"15₪",1),
            new anime("Naruto figuers", R.drawable.naruto,"15₪",1),
            new anime("Zoro earings", R.drawable.zoro,"15₪",1),
            new anime("attack on titans mug", R.drawable.aotmug,"15₪",1),
            new anime("Naruto phone cases", R.drawable.covers,"30₪",1),
            new anime("Demon Slayer Keychains", R.drawable.dkey,"6₪",1),
            new anime("Demon Slayer figuers", R.drawable.demon,"15₪",1),
            new anime("Posters", R.drawable.posters,"8₪",1),
            new anime("Spy X Family lomocards", R.drawable.spylomo,"18₪",1)

    };

    public anime(String name, int imageId, String price,int quantity) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantity=quantity;
    }

    public anime(String name, int imageId, String price) {
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
