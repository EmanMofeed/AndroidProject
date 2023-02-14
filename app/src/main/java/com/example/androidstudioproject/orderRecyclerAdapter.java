package com.example.androidstudioproject;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudioproject.model.Order;

import java.util.ArrayList;

public class orderRecyclerAdapter extends RecyclerView.Adapter<orderRecyclerAdapter.ViewHolder> {
    private ArrayList<Order> ordersArrayList=new ArrayList<>();
    private TextView orderIdTxt;
    private TextView orderDateTxt;
    private TextView orderAmountTxt;
    private TextView orderCity;

    public orderRecyclerAdapter(ArrayList<Order> ordersArrayList) {
        this.ordersArrayList = ordersArrayList;
    }

    @NonNull
    @Override
    public orderRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView card= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_card,parent,false);
        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull orderRecyclerAdapter.ViewHolder holder, int position) {
        CardView cardView=holder.cardView;
        Handler handler = new Handler();
        int pos=position;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                orderIdTxt=cardView.findViewById(R.id.orderIDTxt);
                orderDateTxt = (TextView)cardView.findViewById(R.id.orderDateTxt);
                orderAmountTxt =cardView.findViewById(R.id.orderAmountTxt);
                orderIdTxt.setText(ordersArrayList.get(pos).getOrderId()+"");
                orderDateTxt.setText(ordersArrayList.get(pos).getOrderDate());
                orderAmountTxt.setText(cartRecyclerViewAdapter.totalPriceAfterFee+"");
                orderCity=cardView.findViewById(R.id.orderCityTxt);
                orderCity.setText(ordersArrayList.get(pos).getCity());

            }
        }, 1000);
        //card items
//        orderIdTxt=cardView.findViewById(R.id.orderIDTxt);
//        orderDateTxt = (TextView)cardView.findViewById(R.id.orderDateTxt);
//        orderAmountTxt =cardView.findViewById(R.id.orderAmountTxt);
//        orderIdTxt.setText(ordersArrayList.get(position).getOrderId()+"");
//        orderDateTxt.setText(ordersArrayList.get(position).getOrderDate());
//        orderAmountTxt.setText(cartRecyclerViewAdapter.totalPriceAfterFee+"");
//        orderCity=cardView.findViewById(R.id.orderCityTxt);
//        orderCity.setText(ordersArrayList.get(position).getCity());


    }

    @Override
    public int getItemCount() {
        return ordersArrayList.size();
    }
    //Inner Class
    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView=cardView;
        }
    }
}
