package com.example.movieapp.service.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.BR;
import com.example.movieapp.service.pojo.Movie;
import com.example.movieapp.service.pojo.MovieRespone;
import com.example.movieapp.utilities.Controller;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.movieapp.utilities.Constant.API_KEY;
import static com.example.movieapp.utilities.Constant.LANGUAGE;
import static com.example.movieapp.utilities.Constant.PAGE;

public class MovieRepository {

    private MovieApi movieApi = Controller.getClient();



    public LiveData<List<Movie>> getMovies(){
        MutableLiveData<List<Movie>> data = new MutableLiveData<>();
        movieApi.getMovies("popular",API_KEY,LANGUAGE,PAGE).enqueue(new Callback<MovieRespone>() {
            @Override
            public void onResponse(Call<MovieRespone> call, Response<MovieRespone> response) {
                data.setValue(response.body().getResults());
                Log.d("size: ",""+data.getValue().size());
            }

            @Override
            public void onFailure(Call<MovieRespone> call, Throwable t) {
                Log.e("MovieRespone Error: ",t.getMessage());
            }
        });


        return data;
    }

}
