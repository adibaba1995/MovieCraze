package com.adisoftwares.moviecraze;

import android.app.Application;

import com.adisoftwares.moviecraze.dagger.components.ApplicationComponent;
import com.adisoftwares.moviecraze.dagger.components.DaggerApplicationComponent;
import com.adisoftwares.moviecraze.dagger.components.MovieGridFragmentComponent;
import com.adisoftwares.moviecraze.dagger.modules.ApplicationModule;
import com.adisoftwares.moviecraze.dagger.modules.MovieGridFragmentModule;

/**
 * Created by adityathanekar on 15/06/16.
 */

public class MovieCrazeApplication extends Application {

    private ApplicationComponent applicationComponent;
    private MovieGridFragmentComponent movieGridFragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    public MovieGridFragmentComponent createMovieGridFragmentComponent() {
        movieGridFragmentComponent =  applicationComponent.plus(new MovieGridFragmentModule());
        return movieGridFragmentComponent;
    }

    public void releaseMovieGridFragmentComponent() {
        movieGridFragmentComponent = null;
    }
}
