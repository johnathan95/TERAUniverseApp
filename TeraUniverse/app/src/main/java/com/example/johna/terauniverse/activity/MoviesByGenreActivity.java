package com.example.johna.terauniverse.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.johna.terauniverse.R;
import com.example.johna.terauniverse.others.DividerItemDecoration;
import com.example.johna.terauniverse.adapter.MovieAdapter;
import com.example.johna.terauniverse.model.Movie;
import com.example.johna.terauniverse.model.MovieResponse;
import com.example.johna.terauniverse.rest.ApiClient;
import com.example.johna.terauniverse.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesByGenreActivity extends AppCompatActivity {


    private final static String API_KEY = "a8a19c89f674b6e8528f2cd23df64e13";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_by_genre);
        Intent intent = getIntent();
        int id_genre = intent.getIntExtra("id_genre", 0);
        String genre_name = intent.getStringExtra("genre_name");
        getSupportActionBar().setTitle(genre_name);
        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(), "Erreur avec la clé API", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_by_genre_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);



        Call<MovieResponse> call = apiService.getMoviesByGenre(id_genre, API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                int statusCode = response.code();
                final List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MovieAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}
