package com.example.johna.terauniverse.rest;

import com.example.johna.terauniverse.model.GenreResponse;
import com.example.johna.terauniverse.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Sanoyan on 14/12/2016.
 */

public interface ApiInterface {
    @GET("genre/movie/list")
    Call<GenreResponse> getGenreDetails(@Query("api_key") String apiKey);

    @GET("genre/{id}/movies")
    Call<MovieResponse> getMoviesByGenre(@Path("id") int id, @Query("api_key") String apiKey);


}

//https://api.themoviedb.org/3/genre/27/movies?api_key=a8a19c89f674b6e8528f2cd23df64e13