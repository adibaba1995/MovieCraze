package com.adisoftwares.moviecraze.model;

import com.adisoftwares.moviecraze.model.pojo.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adityathanekar on 17/06/16.
 */

public class MainModelImpl implements MainModel {

    private ArrayList<Results> moviesList;

    public MainModelImpl() {
        moviesList = new ArrayList<>();
    }

    @Override
    public ArrayList<Results> getList() {
        return moviesList;
    }

    @Override
    public void setList(ArrayList<Results> resultList) {
        if(moviesList != null)
            moviesList.clear();
        moviesList = resultList;
    }

    @Override
    public int addData(Results movie) {
        moviesList.add(movie);
        return moviesList.size() - 1;
    }

    @Override
    public void addAllData(List<Results> resultList) {
        moviesList.addAll(resultList);
    }

    @Override
    public Results getDataAt(int position) {
        return moviesList.get(position);
    }
}
