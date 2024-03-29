package com.example.androidstudioproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class HomePageActivity extends AppCompatActivity {
    BottomNavigationView navView;
    Menu menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu,menu);
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        FloatingActionButton home =findViewById(R.id.floatingActionButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent=new Intent(HomePageActivity.this,HomePageActivity.class);
            }
        });
        navView=findViewById(R.id.bottomNavView);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.order:
                        Intent orderIntent = new Intent(HomePageActivity.this, ordersActivity.class);
                        startActivity(orderIntent);
                        break;
                    case R.id.cart:
                        Intent cartIntent = new Intent(HomePageActivity.this, cartActivity.class);
                        startActivity(cartIntent);
//                         Toast.makeText(MainActivity.this, "cart", Toast.LENGTH_SHORT).show();
                        return true;


                }
                return true;

            }
        });


    }


    public void kpopOnClick(View view) {
        Intent intent = new Intent(HomePageActivity.this,kpopActivity.class);
        startActivity(intent);
    }

    public void animeOnClick(View view) {
        Intent intent = new Intent(HomePageActivity.this,animeActivity.class);
        startActivity(intent);
    }



    public void signOutOnClick(View view) {
        Intent intent = new Intent(HomePageActivity.this,MainActivity.class);
        startActivity(intent);
    }
}