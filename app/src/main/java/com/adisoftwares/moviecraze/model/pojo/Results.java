package com.adisoftwares.moviecraze.model.pojo;

/**
 * Created by adityathanekar on 16/06/16.
 */

public class Results {

    private final static String PHOTO_BASE_URL = "http://image.tmdb.org/t/p/";
    private static String PHOTO_SIZE = "w342";

    private double vote_average;
    private String backdrop_path;
    private boolean adult;
    private long id;
    private String title;
    private String overview;
    private String original_language;
    private int[] genre_ids;
    private String release_date;
    private String original_title;
    private long vote_count;
    private String poster_path;
    private boolean video;
    private double popularity;

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public String getPoster_path() {
        if (poster_path != null)
            return PHOTO_BASE_URL + PHOTO_SIZE + poster_path;
        else
            return null;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "ClassPojo [vote_average = " + vote_average + ", backdrop_path = " + backdrop_path + ", adult = " + adult + ", id = " + id + ", title = " + title + ", overview = " + overview + ", original_language = " + original_language + ", genre_ids = " + genre_ids + ", release_date = " + release_date + ", original_title = " + original_title + ", vote_count = " + vote_count + ", poster_path = " + poster_path + ", video = " + video + ", popularity = " + popularity + "]";
    }
}