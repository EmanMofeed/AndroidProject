package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private ImageView img,img1,img2,img3;
    private Animation flying;

    private ImageView instagram;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        img1 =findViewById(R.id.img1);
        img2 =findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        flying = AnimationUtils.loadAnimation(this, R.anim.flying_animation);
//        img.setAnimation(flying);
        img1.setAnimation(flying);
        img2.setAnimation(flying);
        img3.setAnimation(flying);

        instagram=findViewById(R.id.imgInstagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLink("https://www.instagram.com/___euphoria___1/");
            }
        });
    }

    private void goToLink(String link){
        Uri uri = Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void btnOpenLoginPage(View view) {

        Intent fp = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(fp);
    }
    public void btnOpenSignupPage(View view) {

        Intent fp = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(fp);
    }
}