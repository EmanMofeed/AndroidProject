package com.example.androidstudioproject;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidstudioproject.model.euphoriaProductsFactory;
import com.example.androidstudioproject.model.iProductsDA;
import com.example.androidstudioproject.model.products;


import java.util.List;
import java.util.Objects;

public class ProductDetails extends AppCompatActivity {

    private ImageView imgArrow;
    private Animation arrowAnim;

    private TextView txtTitle;
    private TextView txtDetails;
    private ImageView productImg;
    private TextView txtPrice;
    private int numOfItems;
//    private ImageView addAnotherItem;

    //TODO: get data from productsData class to show it in txtDetails below (method)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        setUpViews();
        setDetails();
    }


    private void setUpViews() {
        imgArrow=findViewById(R.id.imgArrow);
        arrowAnim= AnimationUtils.loadAnimation(this,R.anim.add_to_cart_anim);
        imgArrow.setAnimation(arrowAnim);

        txtTitle=findViewById(R.id.txtTitle);
        txtDetails=findViewById(R.id.txtDescription);
        productImg=findViewById(R.id.imgProduct);
        txtPrice=findViewById(R.id.txtPrice);
        numOfItems=Integer.parseInt(findViewById(R.id.numOfItems).toString());
//        addAnotherItem=findViewById(R.id.imgPlus);
    }

    public void openHomePage(View view){
        Intent homeIntent= new Intent(getApplicationContext(),HomePageActivity.class);
        startActivity(homeIntent);
    }

    private void setDetails() {
        euphoriaProductsFactory factory= new euphoriaProductsFactory();
        iProductsDA objProduct=factory.getModel();

        String item ="tom and jerry";
        List<products> products=objProduct.getProductsData(item);

        for(products p:products){
            if(p.getProductName().equals(item)){
                txtDetails.setText(p.getDesc());
                productImg.setImageResource(p.getImg());
                txtPrice.setText("$"+p.getPrice());
                txtTitle.setText(p.getProductName());
            }

        }

//            productImg.setMaxHeight(10);
//            productImg.setMaxWidth(10);
//            productImg.setImageDrawable();
    }

    public void addAnotherItem(View view) {
        numOfItems+=1;
    }

    public void reduceOneItem(View view) {
        if (numOfItems>0)
            numOfItems-=1;
    }
}