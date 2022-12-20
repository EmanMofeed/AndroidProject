package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.androidstudioproject.model.anime;

import java.util.Objects;

public class animeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView recycler = findViewById(R.id.anime_recycler);

        String[] captions = new String[anime.animes.length];
        String[] prices = new String[anime.animes.length];
        int[] ids = new int[anime.animes.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = anime.animes[i].getName();
            prices[i] = anime.animes[i].getPrice();
            ids[i] = anime.animes[i].getImageId();
        }
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        ViewAdapter adapter = new ViewAdapter(captions, ids,prices);
        recycler.setAdapter(adapter);
    }

}