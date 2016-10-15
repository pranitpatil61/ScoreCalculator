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
public class CountryDaoImpl implements CountryDao {

	/**
	 * Database to store country information
	 * */
	private Map<Integer, String> countryStore = new HashMap<Integer, String>();
	
	@Value("${country.file.path}")
	private String countryFilePath;
	
	/**
	 * Loads Countries from external configuration file
	 * and stores in countryStore
	 * Loads periodically
	 * */
	@PostConstruct
	@Scheduled(fixedDelayString = "${countries.load.fixedDelay.milliseconds}")
	@Override
	public void loadCountries() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			countryStore = mapper.readValue(
					new File(countryFilePath), 
					new TypeReference<Map<Integer, String>>(){});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns true if country is present in CountryStore
	 * */
	@Override
	public boolean checkCountryPresent(int countryId) {
		return countryStore.containsKey(countryId);
	}

}
