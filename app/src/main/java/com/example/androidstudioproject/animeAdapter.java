package com.example.androidstudioproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudioproject.model.anime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class animeAdapter extends RecyclerView.Adapter<animeAdapter.ViewHolder>{
    private ArrayList<anime> animeData;
    Context animeContext;
    CardView cardView;

    public animeAdapter(ArrayList<anime> animeData, Context animeContext){
        this.animeData=animeData;
        this.animeContext=animeContext;
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
        Picasso.get().load(animeData.get(position).getImage()).into(imageView);
        TextView txt = (TextView) cardView.findViewById(R.id.txtName);
        txt.setText(animeData.get(position).getName());
        TextView Pritxt = (TextView) cardView.findViewById(R.id.txtprice);
        Pritxt.setText(animeData.get(position).getPrice() + "");
        holder.setImage(animeContext,animeData.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getPosition();
                Intent i = new Intent(animeContext, ProductDetails.class);
                String name = animeData.get(pos).getName();
                String imageId = animeData.get(pos).getImage();
                double price = animeData.get(pos).getPrice();
                String description = animeData.get(pos).getDescription();

                i.putExtra("NAME",name);
                i.putExtra("IMAGE",imageId);
                i.putExtra("PRICE",price);
                i.putExtra("DESCRIPTION",description);
                animeContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animeData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

        public void setImage(Context context,String imageUrl) {
            ImageView imageView = itemView.findViewById(R.id.image);
            Picasso.get().load(imageUrl).into(imageView);
        }
    }
}
