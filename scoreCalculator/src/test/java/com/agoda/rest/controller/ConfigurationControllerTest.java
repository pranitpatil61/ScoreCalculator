package com.agoda.rest.controller;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.agoda.rest.beans.RuleRequest;
import com.agoda.service.ConfigService;
import com.agoda.service.RuleEngine;

@RunWith(MockitoJUnitRunner.class)
public class ConfigurationControllerTest {

	@InjectMocks
	private ConfigurationController controller;
	
	@Mock
	private RuleEngine ruleEngine;
	@Mock
	private ConfigService configService;
	
	
	@Test
	public void testGetRules() {
		Mockito.when(ruleEngine.getAllRules()).thenReturn(new HashMap<String, String>());
		Map result = controller.getRules();
		Assert.assertNotNull(result);
	}

	@Test
	public void testModifyRule() {
		RuleRequest req = new RuleRequest();
		Mockito.when(ruleEngine.modifyRule(req)).thenReturn(true);
		
		boolean result = controller.modifyRule(req);
		assert result;
	}

	@Test
	public void testReloadHotels() {
		controller.reloadHotels();
		Mockito.verify(configService, Mockito.times(1)).reloadHotels();
	}

	@Test
	public void testReloadCountries() {
		controller.reloadCountries();
		Mockito.verify(configService, Mockito.times(1)).reloadCountries();
	}

}
