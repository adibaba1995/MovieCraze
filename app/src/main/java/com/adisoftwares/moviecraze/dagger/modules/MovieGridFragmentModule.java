package com.adisoftwares.moviecraze.dagger.modules;

import com.adisoftwares.moviecraze.dagger.scopes.MovieGridFragmentScope;
import com.adisoftwares.moviecraze.model.MainModel;
import com.adisoftwares.moviecraze.model.MainModelImpl;
import com.adisoftwares.moviecraze.networking.MovieApi;
import com.adisoftwares.moviecraze.presenter.MovieGridPresenter;
import com.adisoftwares.moviecraze.presenter.MovieGridPresenterImpl;
import com.adisoftwares.moviecraze.widget.ViewMoviesAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adityathanekar on 16/06/16.
 */

@Module
public class MovieGridFragmentModule {

    @Provides
    @MovieGridFragmentScope
    public MainModel provideMainModel() {
        return new MainModelImpl();
    }

    @Provides
    @MovieGridFragmentScope
    public MovieGridPresenter provideMovieGridPresenter(MovieApi api, MainModel mainModel) {
        return new MovieGridPresenterImpl(api, mainModel);
    }

    @Provides
    @MovieGridFragmentScope
    MovieApi provideMovieApi() {
        return new MovieApi();
    }

}
