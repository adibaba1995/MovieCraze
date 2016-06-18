package com.adisoftwares.moviecraze.dagger.components;

import com.adisoftwares.moviecraze.dagger.modules.MovieGridFragmentModule;
import com.adisoftwares.moviecraze.dagger.scopes.MovieGridFragmentScope;
import com.adisoftwares.moviecraze.presenter.MovieGridPresenter;
import com.adisoftwares.moviecraze.view.fragment.MovieGridFragment;

import dagger.Subcomponent;

/**
 * Created by adityathanekar on 16/06/16.
 */

@MovieGridFragmentScope
@Subcomponent(modules = { MovieGridFragmentModule.class })
public interface MovieGridFragmentComponent {
    void inject(MovieGridFragment target);
    void inject(MovieGridPresenter target);
}
