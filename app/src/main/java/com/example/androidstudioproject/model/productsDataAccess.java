package com.example.androidstudioproject.model;

import com.example.androidstudioproject.R;

import java.util.ArrayList;
import java.util.List;

public class productsDataAccess implements iProductsDA {
    ArrayList<products> pData =new ArrayList<>();

    public productsDataAccess() {
        pData.add(new products("kPop","amazing coffe cups","jhflwehgvawidjv'wv",20.0, R.drawable.dkey));
        pData.add(new products("kPop","tom and jerry","jhflwehgvawidjv'wv",100.0, R.drawable.demon));
        pData.add(new products("anime","amazing tea cups","jhflwehgvawidjv'wv",20.0, R.drawable.anime));
    }

    public List<products> getProductsData(String name){
        ArrayList<products> data = new ArrayList<>();
        for (products p:pData)
            if (p.getProductName().equals(name)) {
                data.add(p);
            }
        return data;
    }


}
