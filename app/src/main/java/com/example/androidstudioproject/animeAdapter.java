package com.example.androidstudioproject;

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

import com.example.androidstudioproject.model.anime;
import com.example.androidstudioproject.model.kpop;

public class animeAdapter extends RecyclerView.Adapter<animeAdapter.ViewHolder>{
    private anime[] animeData;

    public animeAdapter(anime[]animeData){
        this.animeData=animeData;

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
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), animeData[position].getImageId());
        imageView.setImageDrawable(dr);

        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(animeData[position].getName());
        TextView Pritxt = (TextView)cardView.findViewById(R.id.txtprice);
        Pritxt.setText(animeData[position].getPrice());


//        cardView.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
////               int pos= holder.getPosition();
////               Intent i=new Intent(animeContext,test.class);
//////               i.putExtra("name",captions[pos]) ;
////               animeContext.startActivity(i);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return animeData.length;
    }



    //    public void cardOnClick(View view){
//        int pos= positon;
//        Intent i=new Intent(animeContext,test.class);
////      i.putExtra("name",captions[pos]) ;
//        animeContext.startActivity(i);
//    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }


    }

}