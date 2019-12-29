package com.mhasan.udct.popmoviesstage1.mainpage.presenter;

import java.util.List;

public interface MainPageContract {

	interface Presenter {

		void initializeView();

		void loadPopularMovies();
	}

	interface View {

		void initializeMovieGridViewsWith(List<String> imageList);
	}

}
