package com.adisoftwares.moviecraze.dagger.components;

import com.adisoftwares.moviecraze.dagger.modules.ApplicationModule;
import com.adisoftwares.moviecraze.MovieCrazeApplication;
import com.adisoftwares.moviecraze.dagger.modules.MovieGridFragmentModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adityathanekar on 15/06/16.
 */

@Component(modules = { ApplicationModule.class }) @Singleton
public interface ApplicationComponent {
    void inject(MovieCrazeApplication target);

    MovieGridFragmentComponent plus(MovieGridFragmentModule movieGridFragmentModule);
}
