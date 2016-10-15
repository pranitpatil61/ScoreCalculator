package com.agoda.dao;


public interface HotelDao {

	/**
	 * Loads hotels from external configuration file
	 * and stores in HotelStore
	 * Loads periodically
	 * */
	public void loadHotels();
	
	/**
	 * Returns true if hotel is present in HotelStore
	 * */
	public boolean checkHotelPresent(int hotelId);
	
}
