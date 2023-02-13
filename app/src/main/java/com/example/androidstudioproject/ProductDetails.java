package com.example.androidstudioproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.androidstudioproject.model.anime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class ProductDetails extends AppCompatActivity {

    public static ArrayList<anime> cartAnimeArraylist= new ArrayList<>();
    private ImageView imgArrow;
    private Animation arrowAnim;

    private TextView txtTitle;
    private TextView txtDetails;
    private ImageView productImg;
    private TextView txtPrice;
    private TextView txtNumberOFItems;
    private Button addToCartBtn;
    private int numOfItems;
    private String imgIdFromIntent;


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

        //ADD to cart
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCartBtn.setText("Added");
                String price2 =  txtPrice.getText().toString();
                price2 = price2.replaceAll("₪","");
                double price = Double.parseDouble(price2);
                    anime anime= new anime(txtTitle.getText().toString(), imgIdFromIntent, price,numOfItems,txtDetails.getText().toString()); ;
                Log.d("imgId arrayList",productImg.getId()+"");
                cartAnimeArraylist.add(anime);

            }  });

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
        addToCartBtn=findViewById(R.id.btnAddToCart);

    }

    public void openHomePage(View view){
        Intent homeIntent= new Intent(getApplicationContext(),HomePageActivity.class);
        startActivity(homeIntent);
    }

    @SuppressLint("SetTextI18n")
    private void setDetails() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        imgIdFromIntent = intent.getStringExtra("IMAGE");
        double price = intent.getDoubleExtra("PRICE",0.0);
        String description = intent.getStringExtra("DESCRIPTION");
        Picasso.get().load(imgIdFromIntent).into(productImg);
        txtPrice.setText("₪"+price);
        txtTitle.setText(name);
        txtDetails.setText(description);
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


}