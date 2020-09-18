package com.example.movieapp.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movieapp.R;
import com.example.movieapp.databinding.MovieListItemBinding;
import com.example.movieapp.service.pojo.Movie;

import java.util.ArrayList;
import java.util.List;



public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<Movie> list = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        MovieListItemBinding movieListItemBinding
//                = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.movie_list_item,parent,false);

        MovieListItemBinding movieListItemBinding
                = MovieListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.movieListItemBinding.setMovie(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Movie> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        MovieListItemBinding movieListItemBinding;
        public MovieViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;
        }
    }
}
