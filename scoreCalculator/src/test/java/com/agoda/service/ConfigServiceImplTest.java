package com.agoda.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.agoda.dao.CountryDao;
import com.agoda.dao.HotelDao;

@RunWith(MockitoJUnitRunner.class)
public class ConfigServiceImplTest {

	@InjectMocks
	private ConfigServiceImpl configService;
	
	@Mock
	private HotelDao mockHotelDao;
	@Mock
	private CountryDao mockCountryDao;

	@Test
	public void testReloadHotels() {		
		configService.reloadHotels();
		Mockito.verify(mockHotelDao, Mockito.times(1)).loadHotels();
	}

	@Test
	public void testReloadCountries() {
		configService.reloadCountries();
		Mockito.verify(mockCountryDao, Mockito.times(1)).loadCountries();
	}

}
