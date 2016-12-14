package com.example.johna.terauniverse.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sanoyan on 14/12/2016.
 */

public class GenreResponse {

    @SerializedName("genres")
    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
