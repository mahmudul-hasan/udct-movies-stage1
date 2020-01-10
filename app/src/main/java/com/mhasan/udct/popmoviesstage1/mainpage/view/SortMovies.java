package com.mhasan.udct.popmoviesstage1.mainpage.view;

import android.view.MenuItem;

import com.mhasan.udct.popmoviesstage1.R;
import com.mhasan.udct.popmoviesstage1.mainpage.presenter.MainPageContract.Presenter;
import com.mhasan.udct.popmoviesstage1.utils.Executer;
import com.mhasan.udct.popmoviesstage1.utils.UrlUtils;

import androidx.annotation.NonNull;

/**
 * This class sorts the movies based on the sort category.
 *
 * @author Mahmudul Hasan.
 */
public class SortMovies implements Executer<MenuItem> {

	private final Presenter mainPagePresenter;

	public SortMovies(@NonNull Presenter mainPagePresenter) {
		this.mainPagePresenter = mainPagePresenter;
	}

	@Override
	public void execute(@NonNull MenuItem item) {
		switch (item.getItemId()) {
			case R.id.sortByPopularity:
				mainPagePresenter.sortMoviesBy(UrlUtils.CATEGORY_POPULAR);
				break;
			case R.id.sortByTopRatings:
				mainPagePresenter.sortMoviesBy(UrlUtils.CATEGORY_TOP_RATED);
				break;
		}
	}
}
