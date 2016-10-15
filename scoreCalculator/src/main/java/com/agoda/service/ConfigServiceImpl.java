package com.agoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agoda.dao.CountryDao;
import com.agoda.dao.HotelDao;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Override
	public void reloadHotels() {
		hotelDao.loadHotels();
	}

	@Override
	public void reloadCountries() {
		countryDao.loadCountries();
	}

}
