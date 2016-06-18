package com.adisoftwares.moviecraze.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adisoftwares.moviecraze.MovieCrazeApplication;
import com.adisoftwares.moviecraze.R;
import com.adisoftwares.moviecraze.presenter.MovieGridPresenter;
import com.adisoftwares.moviecraze.view.MovieGridView;
import com.adisoftwares.moviecraze.widget.ViewMoviesAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by adityathanekar on 16/06/16.
 */

public class MovieGridFragment extends Fragment implements MovieGridView {

    @Inject
    MovieGridPresenter presenter;

    @BindView(R.id.movie_recycler_view)
    RecyclerView movieRecyclerView;

    private ViewMoviesAdapter adapter;

    private Unbinder unbinder;

    private static int pageNo = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MovieCrazeApplication)getActivity().getApplication()).createMovieGridFragmentComponent().inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        int size = presenter.getMoviesList().size();
        if (size == 0) {
            pageNo = 1;
            presenter.getMoviesList().clear();
            presenter.loadMovies(pageNo, getString(R.string.sort_popularity_desc), getString(R.string.tmdb_api_key));
            Log.d("Aditya", pageNo + "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_grid, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {
        adapter = new ViewMoviesAdapter(getActivity(), presenter.getMoviesList());
        movieRecyclerView.setAdapter(adapter);

        movieRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int pastVisiblesItems, visibleItemCount, totalItemCount;
            GridLayoutManager mLayoutManager = (GridLayoutManager) movieRecyclerView.getLayoutManager();

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                //this condition is used to check if the user reaches to the end and then fetch another items.
                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    presenter.loadMovies(++pageNo, getString(R.string.sort_popularity_desc), getString(R.string.tmdb_api_key));
                    Log.d("Aditya", pageNo + "");
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((MovieCrazeApplication)getActivity().getApplication()).releaseMovieGridFragmentComponent();
    }

    @Override
    public void notifyRecyclerViewItemInserted(int position) {
        adapter.notifyItemInserted(position);
    }
}
