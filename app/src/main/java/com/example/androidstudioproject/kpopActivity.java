package com.example.androidstudioproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.androidstudioproject.model.kpop;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class kpopActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpop);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView recyclerK = findViewById(R.id.kpop_recycler);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Items");
        ArrayList<kpop> list = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    String type= dataSnapshot.getValue(kpop.class).getCate().trim();
                    if (type.equals("kpop")) {
                        String image = dataSnapshot.getValue(kpop.class).getImage();
                        String name = dataSnapshot.getValue(kpop.class).getName();
                        double price = dataSnapshot.getValue(kpop.class).getPrice();
                        kpop kpop = new kpop(image, name, price);
                        list.add(kpop);
                    }
                }
                Context kpopContext=kpopActivity.this;
                recyclerK.setLayoutManager(new GridLayoutManager(kpopActivity.this,2));
                kpopAdapter adapter = new kpopAdapter(list,kpopContext);
                recyclerK.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}