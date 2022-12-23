package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.androidstudioproject.model.anime;

import java.util.Objects;

public class animeActivity extends AppCompatActivity {
    public anime[] animeData=new anime[anime.animes.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView recycler = findViewById(R.id.anime_recycler);

        for(int i = 0; i<animeData.length;i++){
            animeData[i]=new anime(anime.animes[i].getName(),anime.animes[i].getImageId(),anime.animes[i].getPrice());
        }

        recycler.setLayoutManager(new GridLayoutManager(this,2));
        animeAdapter adapter = new animeAdapter(animeData);
        recycler.setAdapter(adapter);
    }

}