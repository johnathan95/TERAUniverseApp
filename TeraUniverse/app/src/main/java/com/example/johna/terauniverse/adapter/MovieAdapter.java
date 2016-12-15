package com.example.johna.terauniverse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.johna.terauniverse.R;
import com.example.johna.terauniverse.model.Genre;
import com.example.johna.terauniverse.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sanoyan on 15/12/2016.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private final static String POSTER_URL = "http://image.tmdb.org/t/p/w185/";

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout moviesLayout;
        TextView movieName;
        ImageView moviePoster;

        public MovieViewHolder(View v){
            super(v);
            moviesLayout = (LinearLayout)v.findViewById(R.id.movies_layout);
            movieName = (TextView) v.findViewById(R.id.movie_name);
            moviePoster = (ImageView) v.findViewById(R.id.movie_poster);
        }
    }

    public MovieAdapter(List<Movie> movies, int rowLayout, Context context){
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieAdapter.MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        holder.movieName.setText(movies.get(position).getOriginal_title());
        Picasso.with(context).load(POSTER_URL + movies.get(position).getPoster_path()).resize(300, 350).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}