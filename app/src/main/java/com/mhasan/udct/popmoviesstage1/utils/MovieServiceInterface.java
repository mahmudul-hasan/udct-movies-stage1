package com.mhasan.udct.popmoviesstage1.utils;

import com.mhasan.udct.popmoviesstage1.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieServiceInterface {

	@GET("/3/movie/{sortByCategory}")
	Call<MovieResponse> fetchMovieResponse(@Path("sortByCategory") String sortByCategory, @Query("api_key") String apiKey);

}
