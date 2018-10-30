package net.anandsingh.moviez.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.anandsingh.moviez.R;
import net.anandsingh.moviez.constants.Constants;
import net.anandsingh.moviez.listeners.RecyclerViewClickListener;
import net.anandsingh.moviez.model.Movie;

import java.util.List;

/**
 * Created by Anand Singh on 23-07-2016.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> movieList;
    private RecyclerViewClickListener recyclerViewClickListener;

    /**
     * The type My view holder.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * The Title.
         */
        public TextView title;
        /**
         * The Thumbnail.
         */
        public ImageView thumbnail;

        /**
         * Instantiates a new My view holder.
         *
         * @param view the view
         */
        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v, movieList.get(getLayoutPosition()));
        }
    }


    /**
     * Instantiates a new Movies adapter.
     *
     * @param mContext                  the m context
     * @param movieList                 the movie list
     * @param recyclerViewClickListener the recycler view click listener
     */
    public MoviesAdapter(Context mContext, List<Movie> movieList, RecyclerViewClickListener recyclerViewClickListener) {
        this.mContext = mContext;
        this.movieList = movieList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        Glide.with(mContext).load(Constants.MOVIEDB_SMALL_POSTER_URL + movie.getPosterPath()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
