package com.example.movieapp.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.service.pojo.Movie;
import com.example.movieapp.service.pojo.MovieRespone;
import com.example.movieapp.service.repository.MovieRepository;
import com.example.movieapp.utilities.Controller;
import com.example.movieapp.service.repository.MovieApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.movieapp.utilities.Constant.API_KEY;
import static com.example.movieapp.utilities.Constant.LANGUAGE;
import static com.example.movieapp.utilities.Constant.PAGE;

public class MovieViewModel extends ViewModel {

    MovieRepository movieRepository = new MovieRepository();


    public LiveData<List<Movie>> getMovies() {
        return movieRepository.getMovies();
    }

}
