package com.simplertutorials.android.milestone.ui.interfaces;

import android.view.View;
import android.widget.ImageView;

import com.simplertutorials.android.milestone.domain.Movie;

public interface MovieClickListener {
    void onMovieItemClick(Movie movie, View ClickedView);
}
