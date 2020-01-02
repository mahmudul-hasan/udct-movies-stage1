package com.mhasan.udct.popmoviesstage1.mainpage.view;

import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mhasan.udct.popmoviesstage1.R;
import com.mhasan.udct.popmoviesstage1.mainpage.presenter.MainPageContract;
import com.mhasan.udct.popmoviesstage1.mainpage.presenter.MainPagePresenter;
import com.mhasan.udct.popmoviesstage1.utils.UrlUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainPageContract.View {

	private MainPageContract.Presenter mainPagePresenter;

	@Override
	public void initializeMovieGridViewsWith(List<String> imageList) {
		RecyclerView gridViewRv = findViewById(R.id.movieGridViewRv);
		MovieGridViewAdapter adapter = new MovieGridViewAdapter(this, imageList);
		gridViewRv.setLayoutManager(new GridLayoutManager(this, 2));
		gridViewRv.setAdapter(adapter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainPagePresenter = new MainPagePresenter(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sortmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//TODO - handle menu item click
		switch (item.getItemId()) {
			case R.id.sortByPopularity:
				mainPagePresenter.sortMoviesBy(UrlUtils.CATEGORY_POPULAR);
				break;
			case R.id.sortByTopRatings:
				mainPagePresenter.sortMoviesBy(UrlUtils.CATEGORY_TOP_RATED);
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
