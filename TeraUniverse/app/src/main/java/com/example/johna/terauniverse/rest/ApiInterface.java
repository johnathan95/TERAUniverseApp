package com.example.johna.terauniverse.rest;

import com.example.johna.terauniverse.model.GenreResponse;

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
}
