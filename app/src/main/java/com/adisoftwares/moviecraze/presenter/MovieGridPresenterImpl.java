package com.adisoftwares.moviecraze.presenter;

import android.util.Log;

import com.adisoftwares.moviecraze.model.MainModel;
import com.adisoftwares.moviecraze.model.pojo.Movies;
import com.adisoftwares.moviecraze.model.pojo.Results;
import com.adisoftwares.moviecraze.networking.MovieApi;
import com.adisoftwares.moviecraze.view.MovieGridView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by adityathanekar on 17/06/16.
 */

public class MovieGridPresenterImpl implements MovieGridPresenter, Callback<Movies> {

    private WeakReference<MovieGridView> view;
    private MainModel mainModel;
    private MovieApi api;

    @Inject
    public MovieGridPresenterImpl(MovieApi api, MainModel mainModel) {
        this.api = api;
        this.mainModel = mainModel;
    }

    @Override
    public void loadMovies(int page, String sort, String apiKey) {
        api.getMovieApiCallback().getMovies(String.valueOf(page), sort, apiKey).enqueue(this);
    }

    @Override
    public void setView(MovieGridView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public ArrayList<Results> getMoviesList() {
        return mainModel.getList();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResponse(Call<Movies> call, Response<Movies> response) {
        final Results[] resultList = response.body().getResults();
        final Observable<Results> observableString = Observable.create(new Observable.OnSubscribe<Results>() {
            @Override
            public void call(Subscriber<? super Results> observer) {
                for (Results result : resultList) {
                    observer.onNext(result);
                }
                observer.onCompleted();
            }
        });
        Subscription subscriptionPrint = observableString.subscribe(new Observer<Results>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Results item) {
                MovieGridView movieGridView = view.get();
                int position = mainModel.addData(item);
                if(view != null) {
                    movieGridView.notifyRecyclerViewItemInserted(position);
                }
            }
        });
    }

    @Override
    public void onFailure(Call<Movies> call, Throwable t) {
        Log.d("Aditya", t.getMessage());
    }
}
