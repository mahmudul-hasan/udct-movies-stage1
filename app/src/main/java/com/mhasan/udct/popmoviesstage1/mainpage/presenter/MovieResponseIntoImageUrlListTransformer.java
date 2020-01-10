package com.mhasan.udct.popmoviesstage1.mainpage.presenter;

import java.util.ArrayList;
import java.util.List;

import com.mhasan.udct.popmoviesstage1.model.MovieResponse;
import com.mhasan.udct.popmoviesstage1.utils.ImageUrlFactory;
import com.mhasan.udct.popmoviesstage1.utils.Transformer;

import androidx.annotation.NonNull;

/**
 * This transformer class transforms a MovieResponse object into ImageUrlList ogject.
 *
 * @author Mahmudul Hasan.
 */
public class MovieResponseIntoImageUrlListTransformer implements Transformer<MovieResponse, List<String>> {

	@NonNull
	@Override
	public List<String> transform(MovieResponse movieResponse) {
		List<String> imageUrlList = new ArrayList<>();
		for (int i = 0; i < movieResponse.getResults().size(); i++) {
			String posterPath = movieResponse.getResults().get(i).getPoster_path();
			String imageUrl = new ImageUrlFactory(posterPath == null ? "" : posterPath).create();
			imageUrlList.add(imageUrl);
		}
		return imageUrlList;
	}
}
