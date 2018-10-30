package net.anandsingh.moviez.listeners;

import android.view.View;

import net.anandsingh.moviez.model.Movie;

/**
 * Created by Anand Singh on 23-07-2016.
 */
public interface RecyclerViewClickListener {
    /**
     * Recycler view list clicked.
     *
     * @param v            the view
     * @param currentMovie the current movie
     */
    void recyclerViewListClicked(View v, Movie currentMovie);
}
