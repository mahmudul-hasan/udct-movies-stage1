package com.mhasan.udct.popmoviesstage1.mainpage.view;

import com.mhasan.udct.popmoviesstage1.R;
import com.mhasan.udct.popmoviesstage1.utils.Transformer;
import com.mhasan.udct.popmoviesstage1.utils.UrlUtils;

public class SortMenuTitleDeterminerBasedOnCategory implements Transformer<String, Integer> {

	@Override
	public Integer transform(String sortCategory) {
		switch (sortCategory) {
			case UrlUtils.CATEGORY_POPULAR:
				return R.string.popularity;
			case UrlUtils.CATEGORY_TOP_RATED:
				return R.string.highest_rated;
		}
		return -1;
	}
}
