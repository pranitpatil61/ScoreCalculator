package com.agoda.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.agoda.rest.beans.Request;

@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceImplTest {

	@InjectMocks
	private ScoreServiceImpl scoreService;
	
	@Mock
	private RuleEngine ruleEngine;

	@Test
	public void testGetScore() {
		Request request = new Request();
		
		Mockito.when(ruleEngine.executeRulesForScore(request, RuleType.HotelRule, RuleType.CountryRule))
			.thenReturn(5.0);
		
		double result = scoreService.getScore(request);
		Assert.assertEquals(5.0, result, 0.0);
	}

}
