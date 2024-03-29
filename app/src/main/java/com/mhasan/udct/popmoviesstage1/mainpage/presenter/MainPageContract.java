package com.mhasan.udct.popmoviesstage1.mainpage.presenter;

import java.util.List;

import com.mhasan.udct.popmoviesstage1.model.MovieResponse;

import androidx.annotation.NonNull;

/**
 * This is the view-presenter contract for the main page.
 *
 * @author Mahmudul Hasan.
 */
public interface MainPageContract {

	interface Presenter {

		String getCurrentSortCategory();

		void initializeView();

		void loadMovies();

		void sortMoviesBy(@NonNull String sortCategory);
	}

	interface View {

		void initializeMovieGridViewsWith(List<String> imageList, MovieResponse movieResponse);
	}

}
