package com.example.androidstudioproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.androidstudioproject.model.anime;

import java.util.ArrayList;
import java.util.Objects;

public class ProductDetails extends AppCompatActivity {

    private ImageView imgArrow;
    private Animation arrowAnim;

    private TextView txtTitle;
    private TextView txtDetails;
    private ImageView productImg;
    private TextView txtPrice;
    private TextView txtNumberOFItems;
    private int numOfItems;
    final ArrayList<anime> animes = new ArrayList<>();
//    private ImageView addAnotherItem;

    //TODO: get data from productsData class to show it in txtDetails below (method)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setUpViews();
        numOfItems=Integer.parseInt((String) txtNumberOFItems.getText());
        setDetails();
    }


    private void setUpViews() {
        imgArrow=findViewById(R.id.imgArrow);
        arrowAnim= AnimationUtils.loadAnimation(this,R.anim.add_to_cart_anim);
        imgArrow.setAnimation(arrowAnim);
        txtNumberOFItems = findViewById(R.id.numOfItems);
        txtTitle=findViewById(R.id.txtTitle);
        txtDetails=findViewById(R.id.txtDescription);
        productImg=findViewById(R.id.imgProduct);
        txtPrice=findViewById(R.id.txtPrice);
    }

    public void openHomePage(View view){
        Intent homeIntent= new Intent(getApplicationContext(),HomePageActivity.class);
        startActivity(homeIntent);
    }

    @SuppressLint("SetTextI18n")
    private void setDetails() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        int imageId = intent.getIntExtra("IMAGEID",0);
        double price = intent.getDoubleExtra("PRICE",0.0);

        //txtDetails.setText(p.getDesc());
        productImg.setImageResource(imageId);
        txtPrice.setText("₪"+price);
        txtTitle.setText(name);
    }


    @SuppressLint("SetTextI18n")
    public void addAnotherItem(View view) {
        numOfItems+=1;
        txtNumberOFItems.setText(numOfItems+"");
    }

    @SuppressLint("SetTextI18n")
    public void reduceOneItem(View view) {
        if (numOfItems>0)
            numOfItems-=1;
        txtNumberOFItems.setText(numOfItems+"");

    }

    public void addToCart(View view) {
        String price2 =  txtPrice.getText().toString();
        price2 = price2.replaceAll("₪","");
        double price = Double.parseDouble(price2);
        anime anime = new anime(txtTitle.getText().toString(),productImg.getId(),price,numOfItems);
        animes.add(anime);
        Intent intent = new Intent(ProductDetails.this, Cart.class);
        startActivity(intent);

    }
}