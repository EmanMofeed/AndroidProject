package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

public class HomePageActivity extends AppCompatActivity {
    private Button Kbtn;
    private Button Abtn;
    private ImageView addToCartImgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            addToCartImgView=findViewById(R.id.addToCartImgView);
            addToCartImgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent cartActivity=new Intent(HomePageActivity.this,cartActivity.class);
                    startActivity(cartActivity);
                }
            });
        Kbtn = findViewById(R.id.Kbtn);
        Kbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this,kpopActivity.class);
                startActivity(intent);
            }
        });
        Abtn = findViewById(R.id.Abtn);
        Abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomePageActivity.this,animeActivity.class);
                startActivity(intent2);
            }
        });
    }
}