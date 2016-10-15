package com.agoda.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.agoda.dao.CountryDao;
import com.agoda.rest.beans.Request;

@RunWith(MockitoJUnitRunner.class)
public class CountryRuleTest {

	@InjectMocks
	private CountryRule countryRule;
	
	@Mock
	private CountryDao countryDao;
	
	@Test
	public void testExecute() {
		Mockito.when(countryDao.checkCountryPresent(1)).thenReturn(true);
		
		Request req = new Request();
		req.setCountryId(1);
		assert countryRule.execute(req);
	}

}
