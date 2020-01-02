package com.mhasan.udct.popmoviesstage1.utils;

public interface Transformer<O, T> {

	T transform(O original);

}
