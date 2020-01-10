package com.mhasan.udct.popmoviesstage1.detailspage.presenter;

import android.content.Intent;

import com.mhasan.udct.popmoviesstage1.model.MovieResponse.ResultsBean;

/**
 * This is the view-presenter contract for the details page.
 *
 * @author Mahmudul Hasan.
 */
public interface DetailsPageContract {

	interface Presenter {

		void initializeActionBar(ResultsBean resultsBean);

		void populateView(ResultsBean resultsBean);

		ResultsBean retrieveSelectedMovie(Intent intent);
	}

	interface View {

		void populateView(ResultsBean resultsBean);

		void setupActionBar(ResultsBean resultsBean);
	}
}
