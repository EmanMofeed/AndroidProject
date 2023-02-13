package com.example.androidstudioproject;

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
        //card items
        orderIdTxt=cardView.findViewById(R.id.orderIDTxt);
        orderDateTxt = (TextView)cardView.findViewById(R.id.orderDateTxt);
        orderAmountTxt =cardView.findViewById(R.id.orderAmountTxt);
        orderIdTxt.setText(ordersArrayList.get(position).getOrderId()+"");
        orderDateTxt.setText(ordersArrayList.get(position).getOrderDate());
        orderAmountTxt.setText(ordersArrayList.get(position).getOrderAmount()+"");


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
