package com.agoda.dao;


public interface CountryDao {

	/**
	 * Loads Countries from external configuration file
	 * and stores in countryStore
	 * Loads periodically
	 * */
	public void loadCountries();
	
	/**
	 * Returns true if country is present in CountryStore
	 */
	public boolean checkCountryPresent(int countryId);
}
