package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidstudioproject.model.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ordersActivity extends AppCompatActivity {
    public static ArrayList<Order> ordersArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ordersArrayList=cartActivity.ordersList;
        //give each component in the cart card its value
        RecyclerView ordersRecycler=findViewById(R.id.ordersRecyclerView);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String date = sdf.format(System.currentTimeMillis());

        ordersRecycler.setLayoutManager(new LinearLayoutManager(this));
        orderRecyclerAdapter adapter = new orderRecyclerAdapter(ordersArrayList);
        ordersRecycler.setAdapter(adapter);


    }
    public void backHomeFromOrd(View view) {
        Intent intent = new Intent(ordersActivity.this,HomePageActivity.class);
        startActivity(intent);
    }

}