package com.mhasan.udct.popmoviesstage1.mainpage.presenter;

import java.util.ArrayList;
import java.util.List;

import com.mhasan.udct.popmoviesstage1.model.MovieResponse;
import com.mhasan.udct.popmoviesstage1.utils.MovieServiceInterface;
import com.mhasan.udct.popmoviesstage1.utils.UrlUtils;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is the presenter class for the main page.
 *
 * @author Mahmudul Hasan.
 */
public class MainPagePresenter implements MainPageContract.Presenter {

	private List<String> imageUrlList = new ArrayList<>();
	private MovieResponse movieResponse;
	private String sortCategory;
	private MainPageContract.View view;

	public MainPagePresenter(MainPageContract.View view, @NonNull String initialCategory) {
		sortCategory = initialCategory;
		this.view = view;
		sortMoviesBy(sortCategory);
	}

	@Override
	public String getCurrentSortCategory() {
		return sortCategory;
	}

	@Override
	public void initializeView() {
		view.initializeMovieGridViewsWith(imageUrlList, movieResponse);
	}

	@Override
	public void loadMovies() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(UrlUtils.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		MovieServiceInterface movieServiceInterface = retrofit.create(MovieServiceInterface.class);
		Call<MovieResponse> serviceCall
				= movieServiceInterface.fetchMovieResponse(sortCategory, UrlUtils.getApiKey());
		serviceCall.enqueue(new Callback<MovieResponse>() {
			@Override
			public void onFailure(Call<MovieResponse> call, Throwable t) {
				t.getStackTrace();
			}

			@Override
			public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
				movieResponse = response.body();
				imageUrlList = new MovieResponseIntoImageUrlListTransformer().transform(movieResponse);
				initializeView();
			}
		});
	}

	@Override
	public void sortMoviesBy(@NonNull String sortCategory) {
		this.sortCategory = sortCategory;
		loadMovies();
	}
}
