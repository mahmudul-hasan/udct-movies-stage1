package com.mhasan.udct.popmoviesstage1.mainpage.view;

import android.view.View;
import android.widget.ImageView;

import com.mhasan.udct.popmoviesstage1.R;

import androidx.recyclerview.widget.RecyclerView;

/**
 * This is the ViewHolder class used in the MovieGridViewAdapter.
 *
 * @author Mahmudul Hasan.
 */
public class MovieGridViewHolder extends RecyclerView.ViewHolder {

	private ImageView imageView;

	public MovieGridViewHolder(View cellView) {
		super(cellView);
		imageView = cellView.findViewById(R.id.movieImageIv);
	}

	public ImageView getImageView() {
		return imageView;
	}
}
