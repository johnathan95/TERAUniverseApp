package com.example.johna.terauniverse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.johna.terauniverse.R;
import com.example.johna.terauniverse.model.Genre;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Sanoyan on 14/12/2016.
 */

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenreViewHolder> {

    private List<Genre> genres;
    private int rowLayout;
    private Context context;

    public static class GenreViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout genresLayout;
        TextView genreName;

        public GenreViewHolder(View v){
            super(v);
            genresLayout = (LinearLayout)v.findViewById(R.id.genres_layout);
            genreName = (TextView) v.findViewById(R.id.genre_name);
        }
    }

    public GenresAdapter(List<Genre> genres, int rowLayout, Context context){
        this.genres = genres;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public GenresAdapter.GenreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GenresAdapter.GenreViewHolder holder, int position) {
        holder.genreName.setText(genres.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }
}
