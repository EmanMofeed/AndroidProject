package com.example.androidstudioproject;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudioproject.model.Order;
import com.example.androidstudioproject.model.anime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class cartRecyclerViewAdapter extends RecyclerView.Adapter<cartRecyclerViewAdapter.ViewHolder> {
    private ArrayList<anime> cartAnime;
    private TextView totalTextView;
    private TextView totalAfterFeeTextView;
    public static double totalPriceAfterFee;

    //constructor
    public cartRecyclerViewAdapter(ArrayList<anime> cartAnime, TextView total, TextView totalPriceAfterFee) {
       this.cartAnime=cartAnime;
        this.totalTextView =total;
        this.totalAfterFeeTextView =totalPriceAfterFee;
    }

    @NonNull
    @Override
    public cartRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView card= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_details,parent,false);
        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull cartRecyclerViewAdapter.ViewHolder holder, int position) {
        CardView cardView=holder.cardView;

        //card items
        ImageView itemImg= cardView.findViewById(R.id.itemImage);
        TextView quantity=cardView.findViewById(R.id.quantity);
        TextView nameTxt = (TextView)cardView.findViewById(R.id.nameTextView);
        ImageView inc=cardView.findViewById(R.id.plus);
        ImageView dec=cardView.findViewById(R.id.minus);
        TextView price=cardView.findViewById(R.id.priceTextView);
        TextView totalPriceForEach=cardView.findViewById(R.id.totalPriceTextView);

        //give each component in each card its value
        String imgViewId=cartAnime.get(position).getImage();
        Picasso.get().load(imgViewId).into(itemImg);
        //Drawable dr= ContextCompat.getDrawable(holder.cardView.getContext(),imgViewId);
        //itemImg.setImageDrawable(dr);
        nameTxt.setText(cartAnime.get(position).getName());
        price.setText(cartAnime.get(position).getPrice()+"");
        quantity.setText(cartAnime.get(position).getQuantity()+"");

        // save the initial Value of all cart & view in total items textView
        double total=calculateTotalPriceForAllCart();

        totalTextView.setText(total+"");
        calculateTotalPriceAfterFee(totalAfterFeeTextView);
        //animation for recyclerView items
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.cart_recycler_anim));

        //Actions for increment and decrement of quantity
        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we use holder.getAdapterPositin instead the position bcs we can't treat position as fixed
                inc(holder.getAdapterPosition(),quantity,totalPriceForEach);
//                Log.d("tag",data[pos].getQuantity()+"");
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we use holder.getAdapterPositin instead the position bcs we can't treat position as fixed
                dec(holder.getAdapterPosition(),quantity,totalPriceForEach);
            }
        });

        calculateTotalPriceOfEachItem(cartAnime.get(position).getPrice(),position,totalPriceForEach);
        calculateTotalPriceAfterFee(totalAfterFeeTextView);


    }

    private double calculateTotalPriceAfterFee(TextView totalTextViewAfterFee) {
        double totalBeforeFee=calculateTotalPriceForAllCart();
        double totalAfterFee=totalBeforeFee+20;
        totalTextViewAfterFee.setText("$"+totalAfterFee);
        totalPriceAfterFee=totalAfterFee;
        return totalAfterFee;
    }

    private double calculateTotalPriceForAllCart() {
        double total=0;
        for(int i = 0; i<cartAnime.size();i++){
            double value=cartAnime.get(i).calcTotalPrice(cartAnime.get(i).getQuantity(),cartAnime.get(i).getPrice());
            total+= value;
        }
        Log.d("total",total+"");


        return total;
    }


    private void calculateTotalPriceOfEachItem(double price, int position, TextView totalPriceTxtView) {
        double totalPriceAmount=cartAnime.get(position).getQuantity() * price;
        totalPriceTxtView.setText(totalPriceAmount+"");
    }

    private void dec(int position, TextView quantity, TextView totalPrice) {
        if(cartAnime.get(position).getQuantity() > 0 ){
            int value=cartAnime.get(position).getQuantity() -1;
            cartAnime.get(position).setQuantity(value);
            quantity.setText(cartAnime.get(position).getQuantity()+"");}
        else if(cartAnime.get(position).getQuantity() == 0){
            quantity.setText("1");
        }
        //price for each item
        calculateTotalPriceOfEachItem(cartAnime.get(position).getPrice(),position,totalPrice);
        //price for all cart
        double total=calculateTotalPriceForAllCart();
        totalTextView.setText(total+"");
        calculateTotalPriceAfterFee(totalAfterFeeTextView);

        Log.d("dec",cartAnime.get(position).getQuantity()+"");
    }

    private void inc(int position, TextView quantity, TextView totalPrice) {
        int value=cartAnime.get(position).getQuantity() +1;
        cartAnime.get(position).setQuantity(value);
        quantity.setText(cartAnime.get(position).getQuantity()+"");
        Log.d("inc",value+"");
        //price for each item
        calculateTotalPriceOfEachItem(cartAnime.get(position).getPrice(),position,totalPrice);
        //price for all cart
        double total=calculateTotalPriceForAllCart();
        totalTextView.setText(total+"");
        calculateTotalPriceAfterFee(totalAfterFeeTextView);
    }

    @Override
    public int getItemCount() {
        return cartAnime.size();
    }

    public void clear(){
        cartAnime.clear();
        notifyDataSetChanged();

    }

    //Inner class of ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView=cardView;
        }
    }
}


