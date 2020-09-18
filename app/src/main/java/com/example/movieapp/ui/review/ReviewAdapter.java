package com.example.movieapp.ui.review;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.databinding.ReviewListItemBinding;
import com.example.movieapp.service.pojo.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    List<Review> list = new ArrayList<>();

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReviewListItemBinding reviewListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.review_list_item,parent,false);

        return new ReviewViewHolder(reviewListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Review> list) {
        this.list = list;

    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        ReviewListItemBinding reviewListItemBinding;
        public ReviewViewHolder(@NonNull ReviewListItemBinding reviewListItemBinding) {
            super(reviewListItemBinding.getRoot());
        }
    }
}
