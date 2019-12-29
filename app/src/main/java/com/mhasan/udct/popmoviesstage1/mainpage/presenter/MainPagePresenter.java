package com.mhasan.udct.popmoviesstage1.mainpage.presenter;

import java.util.ArrayList;
import java.util.List;

public class MainPagePresenter implements MainPageContract.Presenter {

	private List<String> imageList;
	private MainPageContract.View view;

	public MainPagePresenter(MainPageContract.View view) {
		this.view = view;
		loadPopularMovies();
	}

	@Override
	public void initializeView() {
		view.initializeMovieGridViewsWith(imageList);
	}

	@Override
	public void loadPopularMovies() {
		//TODO - consume the REST API and get the data source.
		//TEST DATA
		imageList = new ArrayList<>();
		imageList.add("https://farm5.staticflickr.com/4403/36538794702_83fd8b63b7_c.jpg");
		imageList.add("https://farm5.staticflickr.com/4354/35684440714_434610d1d6_c.jpg");
		imageList.add("https://farm5.staticflickr.com/4301/35690634410_f5d0e312cb_c.jpg");
		imageList.add("https://farm4.staticflickr.com/3854/32890526884_7dc068fedd_c.jpg");
		imageList.add("https://farm8.staticflickr.com/7787/18143831616_a239c78056_c.jpg");
		imageList.add("https://farm9.staticflickr.com/8745/16657401480_57653ac8b0_c.jpg");
		imageList.add("https://farm3.staticflickr.com/2917/14144166232_44613c53c7_c.jpg");
		imageList.add("https://farm8.staticflickr.com/7453/13960410788_3dd02b7a02_c.jpg");
		imageList.add("https://farm1.staticflickr.com/920/29297133218_de38a7e4c8_c.jpg");
		imageList.add("https://farm2.staticflickr.com/1788/42989123072_6720c9608d_c.jpg");
		imageList.add("https://farm1.staticflickr.com/888/29062858008_89851766c9_c.jpg");
		imageList.add("https://farm2.staticflickr.com/1731/27940806257_8067196b41_c.jpg");
		imageList.add("https://farm1.staticflickr.com/884/42745897912_ff65398e38_c.jpg");
		imageList.add("https://farm2.staticflickr.com/1829/27971893037_1858467f9a_c.jpg");
		imageList.add("https://farm2.staticflickr.com/1822/41996470025_414452d7a0_c.jpg");
		imageList.add("https://farm2.staticflickr.com/1793/42937679651_3094ebb2b9_c.jpg");
		//TEST DATA ends
	}
}
