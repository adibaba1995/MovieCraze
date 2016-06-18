package com.adisoftwares.moviecraze.model.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adityathanekar on 16/06/16.
 */

public class Movies
{
    private Results[] results;

    private long page;

    private long total_pages;

    private long total_results;

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public long getPage ()
    {
        return page;
    }

    public void setPage (long page)
    {
        this.page = page;
    }

    public long getTotal_pages ()
    {
        return total_pages;
    }

    public void setTotal_pages (long total_pages)
    {
        this.total_pages = total_pages;
    }

    public long getTotal_results ()
    {
        return total_results;
    }

    public void setTotal_results (long total_results)
    {
        this.total_results = total_results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", page = "+page+", total_pages = "+total_pages+", total_results = "+total_results+"]";
    }
}

//public final class Movies {
//    public final long page;
//    public final Results results[];
//    public final long total_results;
//    public final long total_pages;
//
//    public Movies(long page, Results[] results, long total_results, long total_pages){
//        this.page = page;
//        this.results = results;
//        this.total_results = total_results;
//        this.total_pages = total_pages;
//    }
//
//    public static final class Results {
//        public final String poster_path;
//        public final boolean adult;
//        public final String overview;
//        public final String release_date;
//        public final int[] genre_ids;
//        public final long id;
//        public final String original_title;
//        public final String original_language;
//        public final String title;
//        public final String backdrop_path;
//        public final double popularity;
//        public final long vote_count;
//        public final boolean video;
//        public final double vote_average;
//
//        public Results(String poster_path, boolean adult, String overview, String release_date, int[] genre_ids, long id, String original_title, String original_language, String title, String backdrop_path, double popularity, long vote_count, boolean video, double vote_average){
//            this.poster_path = poster_path;
//            this.adult = adult;
//            this.overview = overview;
//            this.release_date = release_date;
//            this.genre_ids = genre_ids;
//            this.id = id;
//            this.original_title = original_title;
//            this.original_language = original_language;
//            this.title = title;
//            this.backdrop_path = backdrop_path;
//            this.popularity = popularity;
//            this.vote_count = vote_count;
//            this.video = video;
//            this.vote_average = vote_average;
//        }
//    }
//}