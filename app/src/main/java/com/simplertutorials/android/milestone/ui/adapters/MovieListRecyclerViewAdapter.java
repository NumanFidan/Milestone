package com.simplertutorials.android.milestone.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simplertutorials.android.milestone.DataHolder.DataHolder;
import com.simplertutorials.android.milestone.R;
import com.simplertutorials.android.milestone.ui.interfaces.MovieClickListener;
import com.simplertutorials.android.milestone.domain.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter<MovieListRecyclerViewHolder> {

    private ArrayList<Movie> movieArrayList;
    private Context context;
    private MovieClickListener movieClickListener;

    public MovieListRecyclerViewAdapter(Context context, ArrayList<Movie> movieArrayList,
                                        MovieClickListener movieClickListener) {
        this.context = context;
        this.movieArrayList = movieArrayList;
        this.movieClickListener = movieClickListener;
    }

    @NonNull
    @Override
    public MovieListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_movie_recycler, parent, false);
        return new MovieListRecyclerViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieListRecyclerViewHolder holder, final int i) {

        holder.itemTitle.setText(movieArrayList.get(i).getTitle());
        addGenres(holder.genreLayout, i);
        holder.itemDescription.setText(movieArrayList.get(i).getOverview());
        holder.itemRating.setText(String.valueOf(movieArrayList.get(i).getVoteAverage()));
        setMoviePosterWithPicasso(holder.poster, i);

        holder.detailsBtn.setClickable(false);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieClickListener.onMovieItemClick(movieArrayList.get(i), holder.itemView);
            }
        });

    }

    private void addGenres(LinearLayout genreLayout, int position) {
        ArrayList<Integer> genreList  = movieArrayList.get(position).getGenreIds();
        genreLayout.removeAllViews();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);
        params.gravity = Gravity.CENTER;

        for (int i = 0; i < genreList.size(); i++) {
            TextView genre = new TextView(context);
            genre.setText(DataHolder.getInstance().getGenreMap().get(genreList.get(i)));
            genre.setBackgroundResource(R.drawable.dark_rounded_background);
            genre.setTextColor(Color.WHITE);
            genre.setMaxLines(1);
            genre.setPadding(16, 0, 16, 4);
            genre.setLayoutParams(params);
            genreLayout.addView(genre);
        }
    }

    private void setMoviePosterWithPicasso(ImageView poster, int position) {
        Picasso.get().load(movieArrayList.get(position).getPosterUrl())
                .into(poster);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

}
