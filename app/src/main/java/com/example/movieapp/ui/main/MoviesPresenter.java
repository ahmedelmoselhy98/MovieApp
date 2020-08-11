package com.example.movieapp.ui.main;

import android.os.Handler;
import android.util.Log;

import com.example.movieapp.pojo.Movie;
import com.example.movieapp.pojo.MovieRespone;
import com.example.movieapp.utilities.Controller;
import com.example.movieapp.utilities.MovieApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.movieapp.utilities.Constant.API_KEY;
import static com.example.movieapp.utilities.Constant.LANGUAGE;
import static com.example.movieapp.utilities.Constant.PAGE;

public class MoviesPresenter {

    MoviesView view;
    Retrofit client;
    MovieApi movieApi;
    List<Movie> movieList;
    public MoviesPresenter(MoviesView view) {
        this.view = view;
        movieApi = Controller.getClient();
        movieList = new ArrayList<>();
    }

    // 1- get data from server
//    public List<Movie> getMovies(){
//
//        movieApi.getMovies("popular",API_KEY,LANGUAGE,PAGE).enqueue(new Callback<MovieRespone>() {
//            @Override
//            public void onResponse(Call<MovieRespone> call, Response<MovieRespone> response) {
//                movieList = response.body().getResults();
//            }
//
//            @Override
//            public void onFailure(Call<MovieRespone> call, Throwable t) {
//                Log.d("Failure",t.getMessage());
//            }
//        });
//        return movieList;
//    }
//    // 2- set data to specific view
//    public void setMoviesData(){
//        view.onGetMovies(getMovies());
//    }

    public void getMovies(){
        view.onShowProgressBar();
        movieApi.getMovies("popular",API_KEY,LANGUAGE,PAGE).enqueue(new Callback<MovieRespone>() {
            @Override
            public void onResponse(Call<MovieRespone> call, Response<MovieRespone> response) {
                view.onHideProgressBar();
                view.onGetMovies(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieRespone> call, Throwable t) {
                view.onHideProgressBar();
                view.onFailed(t.getMessage());
            }
        });

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//            }
//        },3000);
    }
}
