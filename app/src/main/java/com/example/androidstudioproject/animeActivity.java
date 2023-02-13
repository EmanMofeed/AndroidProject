package com.example.androidstudioproject;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.androidstudioproject.model.anime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class animeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView recyclerView = findViewById(R.id.anime_recycler);


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Items");
        ArrayList<anime> list = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String type= dataSnapshot.getValue(anime.class).getCate().trim();
                    if(type.equals("anime")) {
                        String image = dataSnapshot.getValue(anime.class).getImage();
                        String name = dataSnapshot.getValue(anime.class).getName();
                        double price = dataSnapshot.getValue(anime.class).getPrice();
                        anime anime = new anime(image, name, price);
                        list.add(anime);
                    }else{
                        continue;
                    }
                }
                recyclerView.setLayoutManager(new GridLayoutManager(animeActivity.this,2));
                animeAdapter adapter = new animeAdapter(list,animeActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void backToHome(View view) {
            Intent intent = new Intent(animeActivity.this,HomePageActivity.class);
            startActivity(intent);
        }
    }
