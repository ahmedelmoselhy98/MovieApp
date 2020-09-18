package com.example.movieapp.service.repository;


import com.example.movieapp.service.pojo.Credits;
import com.example.movieapp.service.pojo.Movie;
import com.example.movieapp.service.pojo.MovieDetail;
import com.example.movieapp.service.pojo.MovieRespone;
import com.example.movieapp.service.pojo.ReviewRespone;
import com.example.movieapp.service.pojo.VideoRespone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    //Get a list of the current {criteria} movies on TMDb. This list updates daily.
    //criteria : popular,top_rated,now_playing,upcoming,now_playing
    @GET("movie/{movie_criteria}")
    public Call<MovieRespone> getMovies(
            @Path("movie_criteria")String movie_criteria,
            @Query("api_key") String api_key,
            @Query("language")String language,
            @Query("page")int page
    );

    // Get a list of recommended movies for a movie.
    @GET("movie/{movie_id}/recommendations")
    Call<List<Movie>> getRecommendations(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key,
            @Query("language")String language,
            @Query("page")int page);


    // similar Get a list of similar movies. This is not the same as the "Recommendation" system you see on the website.
    //These items are assembled by looking at keywords and genres.
    @GET("movie/{movie_id}/similar")
    Call<List<Movie>> getSimilar(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key,
            @Query("language")String language,
            @Query("page")int page);


    // Get the cast and crew for a movie.
    @GET("movie/{movie_id}/credits")
    Call<List<Credits>> getCredits(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

    //Get the primary information about a movie.
    @GET("movie/{movie_id}")
    public Call<MovieDetail> getMovieDetail(
            @Path("movie_id")String movie_id,
            @Query("api_key") String api_key,
            @Query("language")String language,
            @Query("page")int page
    );

    @GET("discover/movie")
    public Call<MovieRespone> getDiscoverMovies(
            @Query("sort_by") String sort_by,
            @Query("api_key") String api_key,
            @Query("language")String language,
            @Query("page")int page
    );



    // Get the videos that have been added to a movie.
    @GET("movie/{movie_id}/videos")
    public Call<VideoRespone> getVideos(
            @Path("movie_id")String movie_id,
            @Query("api_key") String api_key,
            @Query("language")String language
    );


    // Get the user reviews for a movie.
    @GET("movie/{movie_id}/reviews")
    public Call<ReviewRespone> getReviews(
            @Path("movie_id")String movie_id,
            @Query("api_key") String api_key,
            @Query("language")String language,
            @Query("page")int page
    );
}
