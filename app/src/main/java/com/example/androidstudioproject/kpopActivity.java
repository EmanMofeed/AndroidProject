package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.androidstudioproject.model.kpop;

import java.util.Objects;

public class kpopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpop);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView recyclerK = findViewById(R.id.kpop_recycler);

        String[] names = new String[kpop.kpops.length];
        String[] price = new String[kpop.kpops.length];
        int[] imgs = new int[kpop.kpops.length];

        for(int i = 0; i<names.length;i++){
            names[i] = kpop.kpops[i].getName();
            price[i] = kpop.kpops[i].getPrice();
            imgs[i] = kpop.kpops[i].getImageId();
        }
        recyclerK.setLayoutManager(new GridLayoutManager(this,2));
        ViewAdapter adapterk = new ViewAdapter(names, imgs,price);
        recyclerK.setAdapter(adapterk);
    }

}