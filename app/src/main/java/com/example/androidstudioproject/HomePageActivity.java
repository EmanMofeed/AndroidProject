package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {
    private Button Kbtn;
    private Button Abtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


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
}