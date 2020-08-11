package com.example.movieapp.pojo;

import java.util.HashMap;
import java.util.List;

public class MovieRespone {


private int page,total_results,total_pages;
private List<Movie> results;
private HashMap<Object,Object> dates;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public HashMap<Object, Object> getDates() {
        return dates;
    }

    public void setDates(HashMap<Object, Object> dates) {
        this.dates = dates;
    }
}
