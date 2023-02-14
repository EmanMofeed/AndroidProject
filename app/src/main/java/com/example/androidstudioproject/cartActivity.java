package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstudioproject.model.Order;
import com.example.androidstudioproject.model.anime;
import com.example.androidstudioproject.ProductDetails;
import com.example.androidstudioproject.model.kpop;

import java.util.ArrayList;
import java.util.Objects;

public class cartActivity extends AppCompatActivity {
   public static ArrayList<Order> ordersList=new ArrayList<Order>();
    Dialog city_dialog;
    Dialog address_dialog;
    String city;
    Double totaaaaaal;
    cartRecyclerViewAdapter adapter;
    EditText cityTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<anime> cartAnime = new ArrayList<>();
        cartAnime=ProductDetails.cartAnimeArraylist;
        Animation carAnim;
        super.onCreate(savedInstanceState);
        //hide action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cart);
        //give each component in the cart card its value
        RecyclerView cartRecycler= findViewById(R.id.cartRecyclerView);
        TextView myCart=findViewById(R.id.mycartTextView);
        TextView totalPriceForAllCart=findViewById(R.id.itemsTotalTextViewInt);
        TextView totalPriceAfterFee=findViewById(R.id.TotalTextViewInt);
        Button checkOutBtn=findViewById(R.id.checkOutBtn);
        //animation for my cart textView
        carAnim=android.view.animation.AnimationUtils.loadAnimation(this,R.anim.car_anim);
        myCart.setAnimation(carAnim);

        ////////////city dialog///////////
        city_dialog=new Dialog(cartActivity.this);
        //we declared the button of the dialog here because now we declared the dialog
        city_dialog.setContentView(R.layout.city_dialog);
        city_dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.address_background));
        city_dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        city_dialog.getWindow().getAttributes().windowAnimations=R.style.animation;


        checkOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city_dialog.show();
                 cityTxt=city_dialog.findViewById(R.id.cityTxt);
//                 city=cityTxt.getText().toString();

            }
        });

        //////////shipped dialog/////////////
        address_dialog=new Dialog(cartActivity.this);
        Button enetrBtnOnClick=city_dialog.findViewById(R.id.enterBtn);
        //we declared the button of the dialog here because now we declared the dialog
        Button okBtn=address_dialog.findViewById(R.id.okBtn);
        address_dialog.setContentView(R.layout.address_dilog);
        address_dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.address_background));
        address_dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        address_dialog.getWindow().getAttributes().windowAnimations=R.style.animation;


        cartRecycler.setLayoutManager(new LinearLayoutManager(this));
        //we send to the adapter: array of data+totalPriceTextView+totalPriceAfterFeeTextView
         adapter = new cartRecyclerViewAdapter(cartAnime,totalPriceForAllCart,totalPriceAfterFee);
        cartRecycler.setAdapter(adapter);
        totaaaaaal=cartRecyclerViewAdapter.totalPriceAfterFee;
        Log.d("!!!!total!!!!",totaaaaaal+"");

        enetrBtnOnClick.setOnClickListener(new View.OnClickListener() {
//            String city=cityTxt.getText().toString();
//            Order newOrder= new Order(totaaaaaal,city);
Order newOrder= new Order(totaaaaaal);



            @Override
            public void onClick(View view) {
                String city=cityTxt.getText().toString();
                Log.d("!!!!cirt!!!!",city);
                newOrder.setCity(city);
                ordersList.add(newOrder);
                city_dialog.dismiss();
                address_dialog.show();
            }
        });
    }

    public void OKBtnOnClick(View view) {

        Toast.makeText(cartActivity.this, "Your order shipped!", Toast.LENGTH_LONG).show();
        address_dialog.dismiss();
        adapter.clear();
        Intent backToHome=new Intent(this,HomePageActivity.class);
        startActivity(backToHome);
        finish();

    }

    public void backHomeFromCart(View view) {
        Intent intent = new Intent(cartActivity.this,HomePageActivity.class);
        startActivity(intent);
    }


}