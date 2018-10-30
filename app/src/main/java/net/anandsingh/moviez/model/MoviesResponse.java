package net.anandsingh.moviez.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Anand Singh on 23-07-2016.
 */
public class MoviesResponse {

    /**
     * The Movie results.
     */
    @SerializedName("results")
    List<Movie> movieResults;

    /**
     * Gets movie results.
     *
     * @return the movie results
     */
    public List<Movie> getMovieResults() {
        return movieResults;
    }
}
