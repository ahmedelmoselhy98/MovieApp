package com.example.movieapp.ui.main;

import com.example.movieapp.pojo.Movie;

import java.util.List;

public interface MoviesView {

    void onGetMovies(List<Movie> movies);
    void onFailed(String message);
    void onShowProgressBar();
    void onHideProgressBar();

}
