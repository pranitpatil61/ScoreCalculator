package com.agoda.dao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.agoda.rest.beans.Request;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class HotelDaoImpl implements HotelDao {

	/**
	 * Database to store hotel information
	 * */
	private Map<Integer, String> hotelStore = new HashMap<Integer, String>();
	
	@Value("${hotel.file.path}")
	private String hotelFilePath;
	
	/**
	 * Loads hotels from external configuration file
	 * and stores in HotelStore
	 * Loads periodically
	 * @see image
	 * */
	@PostConstruct
	@Scheduled(fixedDelayString = "${countries.load.fixedDelay.milliseconds}")
	@Override
	public void loadHotels() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			hotelStore = mapper.readValue(
					new File(hotelFilePath), 
					new TypeReference<Map<Integer, String>>(){});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns true if hotel is present in HotelStore
	 * */
	@Override
	public boolean checkHotelPresent(int hotelId) {
		return hotelStore.containsKey(hotelId);
	}

}
