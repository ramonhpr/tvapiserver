package com.example.ramon.seriestvmaze;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramon on 05/09/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.SerieViewHolder> {
    List<Serie> series;
    public static class SerieViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView year;
        ImageView image;

        SerieViewHolder(View item) {
            super(item);
            cv = item.findViewById(R.id.cv);
            name = item.findViewById(R.id.serie_name);
            year = item.findViewById(R.id.serie_age);
            image = item.findViewById(R.id.serie_photo);
        }
    }
    RVAdapter(List<Serie> series){
        this.series = series;
    }
    @Override
    public SerieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_content, parent, false);
        SerieViewHolder svh = new SerieViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(SerieViewHolder holder, int i) {
        holder.name.setText(series.get(i).name);
        holder.year.setText(series.get(i).year);
        ImageLoadTask ilt = new ImageLoadTask(series.get(i).urlImage, holder.image, new Callback() {
            @Override
            public void onResponse(Object results) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
