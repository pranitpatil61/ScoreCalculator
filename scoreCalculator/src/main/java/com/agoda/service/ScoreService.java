package com.agoda.service;

import com.agoda.rest.beans.Request;

public interface ScoreService {

	/**
	 * Calculates the scores depending on define rule
	 * Returns calculated score
	 * */
	public double getScore(Request request);
	
}
