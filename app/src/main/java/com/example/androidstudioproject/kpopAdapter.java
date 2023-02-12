package com.example.androidstudioproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidstudioproject.model.kpop;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class kpopAdapter extends RecyclerView.Adapter<kpopAdapter.ViewHolder>{
    private ArrayList<kpop> kpopData;
    Context kpopContext;
    CardView cardView;
    public kpopAdapter(ArrayList<kpop> kpopData, Context kpopContext){
        this.kpopData=kpopData;
        this.kpopContext=kpopContext;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardimage,
                parent,
                false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Picasso.get().load(kpopData.get(position).getImage()).into(imageView);
        TextView txt = (TextView) cardView.findViewById(R.id.txtName);
        txt.setText(kpopData.get(position).getName());
        TextView Pritxt = (TextView) cardView.findViewById(R.id.txtprice);
        Pritxt.setText(kpopData.get(position).getPrice() + "");
        holder.setImage(kpopContext,kpopData.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getPosition();
                Intent i = new Intent(kpopContext, ProductDetails.class);
                String name = kpopData.get(pos).getName();
                String imageId = kpopData.get(pos).getImage();
                double price = kpopData.get(pos).getPrice();
                String description = kpopData.get(pos).getDescription();

                i.putExtra("NAME",name);
                i.putExtra("IMAGE",imageId);
                i.putExtra("PRICE",price);
                i.putExtra("DESCRIPTION",description);
                kpopContext.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return kpopData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }

        public void setImage(Context context,String imageUrl) {
            ImageView imageView = itemView.findViewById(R.id.image);
            Picasso.get().load(imageUrl).into(imageView);
        }
        }
    }
