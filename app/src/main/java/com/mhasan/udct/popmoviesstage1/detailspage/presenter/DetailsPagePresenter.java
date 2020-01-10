package com.mhasan.udct.popmoviesstage1.detailspage.presenter;

import android.content.Intent;

import com.mhasan.udct.popmoviesstage1.detailspage.presenter.DetailsPageContract.View;
import com.mhasan.udct.popmoviesstage1.detailspage.view.RetrieveSelectedMovieFromIntent;
import com.mhasan.udct.popmoviesstage1.model.MovieResponse.ResultsBean;

/**
 * This is the details view presenter class.
 *
 * @author Mahmudul Hasan.
 */
public class DetailsPagePresenter implements DetailsPageContract.Presenter {

	private final DetailsPageContract.View view;

	public DetailsPagePresenter(View view, Intent intent) {
		this.view = view;
		ResultsBean resultsBean = retrieveSelectedMovie(intent);
		initializeActionBar(resultsBean);
		populateView(resultsBean);
	}

	@Override
	public void initializeActionBar(ResultsBean resultsBean) {
		view.setupActionBar(resultsBean);
	}

	@Override
	public void populateView(ResultsBean resultsBean) {
		view.populateView(resultsBean);
	}

	@Override
	public ResultsBean retrieveSelectedMovie(Intent intent) {
		return new RetrieveSelectedMovieFromIntent().transform(intent);
	}
}
