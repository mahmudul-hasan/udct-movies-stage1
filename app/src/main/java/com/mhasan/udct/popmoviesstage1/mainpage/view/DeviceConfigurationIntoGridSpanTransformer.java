package com.mhasan.udct.popmoviesstage1.mainpage.view;

import android.content.res.Configuration;

import com.mhasan.udct.popmoviesstage1.utils.Transformer;

import androidx.annotation.NonNull;

/**
 * This is the transformer class that transforms a device configuration into a grid span number.
 *
 * @authos Mahmudul Hasan.
 */
public class DeviceConfigurationIntoGridSpanTransformer implements Transformer<Configuration, Integer> {

	@Override
	public Integer transform(@NonNull Configuration configuration) {
		return configuration.orientation == Configuration.ORIENTATION_PORTRAIT ? 2 : 3;
	}
}
