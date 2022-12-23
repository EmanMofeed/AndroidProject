package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.androidstudioproject.model.anime;
import com.example.androidstudioproject.model.kpop;

import java.util.Objects;

public class kpopActivity extends AppCompatActivity {
    public kpop[] kpopData=new kpop[kpop.kpops.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpop);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView recyclerK = findViewById(R.id.kpop_recycler);


        Context kpopContext=kpopActivity.this;
        for(int i = 0; i<kpopData.length;i++){
            kpopData[i]=new kpop(kpop.kpops[i].getName(),kpop.kpops[i].getImageId(),kpop.kpops[i].getPrice());
        }


        recyclerK.setLayoutManager(new GridLayoutManager(this,2));
        kpopAdapter adapter = new kpopAdapter(kpopData,kpopContext);
        recyclerK.setAdapter(adapter);
    }

}