package com.adisoftwares.moviecraze.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.adisoftwares.moviecraze.R;
import com.adisoftwares.moviecraze.model.pojo.Results;
import com.adisoftwares.moviecraze.utils.Utility;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aditya Thanekar on 6/16/2015.
 */
public class ViewMoviesAdapter extends RecyclerView.Adapter<ViewMoviesAdapter.MoviesViewHolder> {

    private LayoutInflater inflater;

    List<Results> data;
    Context context;

    public ViewMoviesAdapter(Context context, ArrayList<Results> movies) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        data = movies;
        final float scale = context.getResources().getDisplayMetrics().density;
        int pixels = (int) (100 * scale + 0.5f);
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    public void clear() {
        data.clear();
    }

    @Override
    public ViewMoviesAdapter.MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_recyclerview_item, parent, false);
        MoviesViewHolder holder = new MoviesViewHolder(view);
        return holder;
    }

    @Override
    public void onViewRecycled(MoviesViewHolder holder) {
        Glide.clear(holder.poster);
    }

    @Override
    public void onBindViewHolder(final ViewMoviesAdapter.MoviesViewHolder holder, int position) {
        Results current = data.get(position);

        Glide.with(context).load(current.getPoster_path()).into(holder.poster);

        holder.releaseDate.setText(Utility.getYearFromDate(current.getRelease_date()));
        holder.rating.setText(String.valueOf(current.getVote_average()));
        holder.rating.setTextColor(getRatingColor(current.getVote_average()));
        holder.parent.setSelected(true);
    }

    public int getRatingColor(double rating) {
        int colorId = 0;
        if (rating < 6)
            colorId = R.color.red;
        else if (rating >= 6 && rating < 7)
            colorId = R.color.amber;
        else if (rating >= 7 && rating < 8)
            colorId = R.color.green;
        else if (rating >= 8)
            colorId = R.color.white;
        return context.getResources().getColor(colorId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieContainer)
        FrameLayout movieContainer;
        @BindView(R.id.poster)
        ImageView poster;
        @BindView(R.id.releaseDate)
        TextView releaseDate;
        @BindView(R.id.rating)
        TextView rating;

        View parent;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            parent = itemView;
            ButterKnife.bind(this, itemView);
            rating.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            releaseDate.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        }
    }
}
