package com.example.movieapp.utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.movieapp.utilities.Constant.MOVIE_BASE_URL;

public class Controller {

    private static Retrofit mRetrofit = null;
    private static MovieApi movieApi = null;

    public static MovieApi getClient(){

        if (mRetrofit == null){

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(MOVIE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            movieApi = mRetrofit.create(MovieApi.class);
        }
        return movieApi;
    }

}
