package com.mhasan.udct.popmoviesstage1.detailspage.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhasan.udct.popmoviesstage1.R;
import com.mhasan.udct.popmoviesstage1.detailspage.presenter.DetailsPageContract;
import com.mhasan.udct.popmoviesstage1.detailspage.presenter.DetailsPagePresenter;
import com.mhasan.udct.popmoviesstage1.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmoviesstage1.utils.ImageUrlFactory;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsPageActivity extends AppCompatActivity implements DetailsPageContract.View {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_page);
		new DetailsPagePresenter(this, getIntent());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return false;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void populateView(ResultsBean selectedMovie) {
		ImageView imageView = findViewById(R.id.movieDetailsImageIv);
		TextView ratings = findViewById(R.id.movieDetailsAverageTv);
		TextView releaseDate = findViewById(R.id.movieDetailsReleaseDateTv);
		TextView synopsis = findViewById(R.id.movieDetailsSynopsisTv);
		String imagePath = new ImageUrlFactory(selectedMovie.getPoster_path()).create();
		Picasso.get().load(imagePath).resize(185, 277).centerCrop().into(imageView);
		ratings.setText(String.valueOf(selectedMovie.getVote_average()));
		releaseDate.setText(selectedMovie.getRelease_date());
		synopsis.setText(selectedMovie.getOverview());

	}

	@Override
	public void setupActionBar(ResultsBean resultsBean) {
		setTitle(resultsBean.getTitle());
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
}
