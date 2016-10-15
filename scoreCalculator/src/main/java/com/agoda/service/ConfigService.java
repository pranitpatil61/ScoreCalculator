package com.agoda.service;

public interface ConfigService {

	/**
	 * Reload Hotels from Hotels File
	 */
	public void reloadHotels();
	
	/**
	 * Reload Countries from Countries File
	 */
	public void reloadCountries();
}
