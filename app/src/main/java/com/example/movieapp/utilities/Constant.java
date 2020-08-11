package com.example.movieapp.utilities;

import com.example.movieapp.BuildConfig;

public final class Constant {

    public Constant() {
    }

    public static final String MOVIE_BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = BuildConfig.ApiKey;
    public static final int PAGE = 1;
    public static final String LANGUAGE = "en-US";


    /** The base image URL to build the complete url that is necessary for fetching the image */
    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    /** The image file size to build the complete url that is necessary for fetching the image*/
    public static final String BACKDROP_FILE_SIZE ="w500";

    /** The YouTube base URL that is necessary for displaying trailers */
    public static final String YOUTUBE_BASE_URL = "https://www.youtube.com/watch?v=";

    /** The YouTube thumbnail base URL that is used to display YouTube video Thumbnails*/
    public static final String YOUTUBE_THUMBNAIL_BASE_URL = "https://img.youtube.com/vi/";
    public static final String YOUTUBE_THUMBNAIL_URL_JPG = "/0.jpg";

    /** The base URL used for sharing text*/
    public static final String SHARE_URL = "https://www.themoviedb.org/movie/";


    /** Pattern used in FormatUtils */
    public static final String PATTERN_FORMAT_NUMBER = "#,###";
    public static final String PATTERN_FORMAT_CURRENCY = "$###,###";
    public static final String PATTERN_FORMAT_DATE_INPUT = "yyyy-MM-dd";
    public static final String PATTERN_FORMAT_DATE_OUTPUT = "MMM dd, yyyy";


    /** Constant for formatting runtime */
    public static final int ZERO = 0;
}
