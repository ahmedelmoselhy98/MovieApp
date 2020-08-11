package com.example.movieapp.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.pojo.Movie;
import com.example.movieapp.pojo.MovieRespone;
import com.example.movieapp.utilities.Controller;
import com.example.movieapp.utilities.MovieApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.movieapp.utilities.Constant.API_KEY;
import static com.example.movieapp.utilities.Constant.LANGUAGE;
import static com.example.movieapp.utilities.Constant.PAGE;

public class MovieViewModel extends ViewModel {

    MovieApi movieApi;
    public MutableLiveData<List<Movie>> movieLiveData = new MutableLiveData<>();

    public void getMovies() {
        movieApi = Controller.getClient();
        movieApi.getMovies("popular", API_KEY, LANGUAGE, PAGE).enqueue(new Callback<MovieRespone>() {
            @Override
            public void onResponse(Call<MovieRespone> call, Response<MovieRespone> response) {
                movieLiveData.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieRespone> call, Throwable t) {
                Log.d("Error: ", t.getMessage());
            }
        });
    }

}
