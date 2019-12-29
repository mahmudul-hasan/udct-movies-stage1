package com.mhasan.udct.popmoviesstage1.mainpage.view;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.mhasan.udct.popmoviesstage1.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class MovieGridViewAdapter extends Adapter<MovieGridViewHolder> {

	private Context context;
	private List<String> imageList;

	public MovieGridViewAdapter(Context context, List<String> imageList) {
		this.context = context;
		this.imageList = imageList;
	}

	@Override
	public int getItemCount() {
		return imageList.size();
	}

	@Override
	public void onBindViewHolder(@NonNull MovieGridViewHolder holder, int position) {
		String imagePath = imageList.get(position);
		Picasso.get().load(imagePath).resize(185, 277).centerCrop().into(holder.getImageView());
		holder.getImageView().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO - handle cell click.
			}
		});
	}

	@NonNull
	@Override
	public MovieGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_grid_cell, parent, false);
		return new MovieGridViewHolder(view);
	}
}
