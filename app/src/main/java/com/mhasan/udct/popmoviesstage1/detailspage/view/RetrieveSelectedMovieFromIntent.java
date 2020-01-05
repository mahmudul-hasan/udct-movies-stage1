package com.mhasan.udct.popmoviesstage1.detailspage.view;

import android.content.Intent;
import android.os.Bundle;

import com.mhasan.udct.popmoviesstage1.model.MovieResponse;
import com.mhasan.udct.popmoviesstage1.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmoviesstage1.utils.Transformer;

import static com.mhasan.udct.popmoviesstage1.mainpage.view.MovieGridViewAdapter.DATA_RETRIEVAL_KEY;

public class RetrieveSelectedMovieFromIntent implements Transformer<Intent, MovieResponse.ResultsBean> {

	@Override
	public ResultsBean transform(Intent intent) {
		Bundle bundle = intent.getExtras();
		return bundle.getParcelable(DATA_RETRIEVAL_KEY);
	}
}
