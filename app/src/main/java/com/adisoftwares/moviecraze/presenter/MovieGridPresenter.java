package com.adisoftwares.moviecraze.presenter;

import com.adisoftwares.moviecraze.model.pojo.Results;
import com.adisoftwares.moviecraze.view.MovieGridView;

import java.util.ArrayList;

/**
 * Created by adityathanekar on 17/06/16.
 */

public interface MovieGridPresenter extends Lifecycle{
    void loadMovies(int page, String sort, String apiKey);
    void setView(MovieGridView view);
    ArrayList<Results> getMoviesList();
}
