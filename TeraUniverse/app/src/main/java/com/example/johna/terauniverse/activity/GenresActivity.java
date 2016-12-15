package com.example.johna.terauniverse.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.johna.terauniverse.R;
import com.example.johna.terauniverse.others.ClickListener;
import com.example.johna.terauniverse.others.DividerItemDecoration;
import com.example.johna.terauniverse.adapter.GenresAdapter;
import com.example.johna.terauniverse.others.RecyclerTouchListener;
import com.example.johna.terauniverse.model.Genre;
import com.example.johna.terauniverse.model.GenreResponse;
import com.example.johna.terauniverse.rest.ApiClient;
import com.example.johna.terauniverse.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenresActivity extends AppCompatActivity {

    private final static String API_KEY = "a8a19c89f674b6e8528f2cd23df64e13";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(), "Erreur avec la clé API", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.genres_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<GenreResponse> call = apiService.getGenreDetails(API_KEY);
        call.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                int statusCode = response.code();
                final List<Genre> genres = response.body().getGenres();
                recyclerView.setAdapter(new GenresAdapter(genres, R.layout.list_item_genre, getApplicationContext()));
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext()));
                recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Genre genre = genres.get(position);
                        Intent i = new Intent(GenresActivity.this, MoviesByGenreActivity.class);
                        i.putExtra("id_genre", genre.getId());
                        i.putExtra("genre_name", genre.getName());
                        startActivity(i);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {

            }
        });
    }
}
