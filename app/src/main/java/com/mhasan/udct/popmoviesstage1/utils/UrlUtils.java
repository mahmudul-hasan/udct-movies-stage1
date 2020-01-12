package com.mhasan.udct.popmoviesstage1.utils;

/**
 * This is the utility class for the Urls.
 *
 * @author Mahmudul Hasan.
 */
public class UrlUtils {

	private static final String API_KEY = "<PUT YOUR API KEY>";

	public static final String BASE_URL = "https://api.themoviedb.org";
	public static final String CATEGORY_POPULAR = "popular";
	public static final String CATEGORY_TOP_RATED = "top_rated";

	public static String getApiKey() {
		return API_KEY;
	}
}
