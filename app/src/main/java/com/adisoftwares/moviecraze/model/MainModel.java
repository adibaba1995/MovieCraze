package com.adisoftwares.moviecraze.model;

import com.adisoftwares.moviecraze.model.pojo.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adityathanekar on 17/06/16.
 */

public interface MainModel {
    public ArrayList<Results> getList();
    public void setList(ArrayList<Results> resultList);
    public int addData(Results movie);
    public void addAllData(List<Results> resultList);
    public Results getDataAt(int position);
}
