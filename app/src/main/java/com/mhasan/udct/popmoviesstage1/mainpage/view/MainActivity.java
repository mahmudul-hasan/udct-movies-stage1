package com.mhasan.udct.popmoviesstage1.mainpage.view;

import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mhasan.udct.popmoviesstage1.R;
import com.mhasan.udct.popmoviesstage1.mainpage.presenter.MainPageContract;
import com.mhasan.udct.popmoviesstage1.mainpage.presenter.MainPagePresenter;
import com.mhasan.udct.popmoviesstage1.model.MovieResponse;
import com.mhasan.udct.popmoviesstage1.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainPageContract.View {

	private static final String SAVED_CATEGORY_KEY = "savedCategoryKey";
	private MainPageContract.Presenter mainPagePresenter;
	private String menuClicked = "";

	private String getMenuClicked() {
		return menuClicked;
	}

	private int getSpanCount() {
		return new DeviceConfigurationIntoGridSpanTransformer().transform(getResources().getConfiguration());
	}

	@Override
	public void initializeMovieGridViewsWith(List<String> imageList, MovieResponse movieResponse) {
		RecyclerView gridViewRv = findViewById(R.id.movieGridViewRv);
		MovieGridViewAdapter adapter = new MovieGridViewAdapter(this, imageList, movieResponse);
		gridViewRv.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
		gridViewRv.setAdapter(adapter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String initialCategory = savedInstanceState == null ? UrlUtils.CATEGORY_POPULAR : savedInstanceState.getString(SAVED_CATEGORY_KEY);
		mainPagePresenter = new MainPagePresenter(this, initialCategory);
		updateMenuTitle(getString(new SortMenuTitleDeterminerBasedOnCategory().transform(initialCategory)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sortmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.sortByPopularity:
				mainPagePresenter.sortMoviesBy(UrlUtils.CATEGORY_POPULAR);
				break;
			case R.id.sortByTopRatings:
				mainPagePresenter.sortMoviesBy(UrlUtils.CATEGORY_TOP_RATED);
				break;
		}
		updateMenuTitle(String.valueOf(item.getTitle()));
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem item = menu.findItem(R.id.sortMenu);
		String title = getString(R.string.sort_movies) + ": \n" + getMenuClicked();
		item.setTitle(title);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString(SAVED_CATEGORY_KEY, mainPagePresenter.getCurrentSortCategory());
		super.onSaveInstanceState(outState);
	}

	private void setMenuClicked(@NonNull String menuClicked) {
		this.menuClicked = menuClicked;
	}

	private void updateMenuTitle(@NonNull String sortedByTitle) {
		setMenuClicked(sortedByTitle);
		invalidateOptionsMenu();
	}
}
