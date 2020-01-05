package com.mhasan.udct.popmoviesstage1.mainpage.presenter;

import java.util.List;

import com.mhasan.udct.popmoviesstage1.model.MovieResponse;

import androidx.annotation.NonNull;

public interface MainPageContract {

	interface Presenter {

		void initializeView();

		void loadMovies();

		void sortMoviesBy(@NonNull String sortCategory);
	}

	interface View {

		void initializeMovieGridViewsWith(List<String> imageList, MovieResponse movieResponse);
	}

}
