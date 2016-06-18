package com.adisoftwares.moviecraze.networking;

import com.adisoftwares.moviecraze.model.pojo.Movies;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adityathanekar on 17/06/16.
 */

public class MovieApi {

    public interface MovieApiCallback {
        @GET("3/discover/movie")
        public Call<Movies> getMovies(@Query("page") String page, @Query("sort_by") String sort, @Query("api_key") String api_key);
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MovieApiCallback movieApiCallback = retrofit.create(MovieApiCallback.class);

    public MovieApiCallback getMovieApiCallback() {
        return movieApiCallback;
    }

}
