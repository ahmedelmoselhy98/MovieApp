package com.example.movieapp.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.movieapp.R;
import com.example.movieapp.databinding.ActivityMainBinding;
import com.example.movieapp.service.pojo.Movie;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    MovieViewModel movieModelView;
    MovieAdapter movieAdapter = new MovieAdapter();
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(movieModelView);
        binding.setLifecycleOwner(this);
//        MovieApi movieApi = Controller.getClient().create( MovieApi.class);
//        movieApi.getMovies("popular",API_KEY,LANGUAGE,PAGE).enqueue(new Callback<MovieRespone>() {
//            @Override
//            public void onResponse(Call<MovieRespone> call, Response<MovieRespone> response) {
//                Log.d("Number Of Movies: ",""+response.body().getResults().size());
//
//                for (Movie movie: response.body().getResults()){
//                    Log.d("Movie Title",movie.getTitle());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieRespone> call, Throwable t) {
//                Log.d("Failure",t.getMessage());
//            }
//        });
//        movieApi.getDiscoverMovies("popularity.desc",API_KEY,LANGUAGE,PAGE).enqueue(new Callback<MovieRespone>() {
//            @Override
//            public void onResponse(Call<MovieRespone> call, Response<MovieRespone> response) {
//                Log.d("Number Of Movies: ",""+response.body().getResults().size());
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Success !");
//                for (Movie movie: response.body().getResults()){
//                    Log.d("Movie Title",movie.getTitle());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieRespone> call, Throwable t) {
//                Log.d("Failure",t.getMessage());
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Failed !");
//            }
//        });
//        movieApi.getReviews("454626",API_KEY,LANGUAGE,PAGE).enqueue(new Callback<ReviewRespone>() {
//            @Override
//            public void onResponse(Call<ReviewRespone> call, Response<ReviewRespone> response) {
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Success !");
//                Log.d("Number Of Reviews: ",""+response.body().getResults().size());
//                for (Review review: response.body().getResults()){
//                    Log.d("Review Author: ",review.getAuthor());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ReviewRespone> call, Throwable t) {
//                Log.d("Failure",t.getMessage());
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Failed !");
//            }
//        });
//        movieApi.getVideos("454626",API_KEY,LANGUAGE).enqueue(new Callback<VideoRespone>() {
//            @Override
//            public void onResponse(Call<VideoRespone> call, Response<VideoRespone> response) {
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Success !");
//                Log.d("Number Of Videos: ",""+response.body().getResults().size());
//                for (Video video: response.body().getResults()){
//                    Log.d("Video Name: ",video.getName());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<VideoRespone> call, Throwable t) {
//                Log.d("Failure",t.getMessage());
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Failed !");
//            }
//        });
//        movieApi.getMovieDetail("454626",API_KEY,LANGUAGE,PAGE).enqueue(new Callback<MovieDetail>() {
//            @Override
//            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Success !");
//                Log.d("Movie Revenue:", FormatUtils.formatCurrency(response.body().getRevenue()));
//                Log.d("Movie Runtime:", FormatUtils.formatTime(MainActivity.this,response.body().getRuntime()));
//                Log.d("Movie Release Date:", FormatUtils.formatDate(response.body().getRelease_date()));
//            }
//
//            @Override
//            public void onFailure(Call<MovieDetail> call, Throwable t) {
//                Log.d("Failure",t.getMessage());
//                circleProgressBar.setVisibility(View.GONE);
//                tvStatus.setText("Loading Data Failed !");
//            }
//        });
        movieModelView = ViewModelProviders.of(this).get(MovieViewModel.class);
        observeMovieData();
    }

    private void observeMovieData(){
        movieModelView.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if (!movies.isEmpty()) {
                    movieAdapter.setList(movies);
                    binding.recycler.setAdapter(movieAdapter);
                    binding.recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                } else {
                    Toast.makeText(MainActivity.this, "No Movies Found !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
