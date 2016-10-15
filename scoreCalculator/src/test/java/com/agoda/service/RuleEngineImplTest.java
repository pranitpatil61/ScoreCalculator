package com.agoda.service;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;

import com.agoda.exception.ValidationException;
import com.agoda.rest.beans.Request;
import com.agoda.rest.beans.RuleRequest;

@RunWith(MockitoJUnitRunner.class)
public class RuleEngineImplTest {
	
	@InjectMocks
	private RuleEngineImpl ruleEngine;
	
	@Mock
	private HotelRule hotelRule;
	
	@Before
	public void setUp() throws Exception {
		Map<RuleType, Rule> ruleStore = new LinkedHashMap<>();
		ruleStore.put(RuleType.HotelRule, new Rule("HotelRule", hotelRule, 5, true));
		ruleEngine.setRuleStore(ruleStore);
	}

	@Test
	public void testExecuteRulesForScore() {
		Request request = new Request();
		request.setHotelId(1);
		
		Mockito.when(hotelRule.execute(Mockito.any(Request.class))).thenReturn(true);
		
		double score = ruleEngine.executeRulesForScore(request, RuleType.HotelRule);
		
		Assert.assertEquals(5.00, score);
		
		
		Mockito.when(hotelRule.execute(Mockito.any(Request.class))).thenThrow(new RuntimeException("Testing"));
		score = ruleEngine.executeRulesForScore(request, RuleType.HotelRule);
		
		Assert.assertEquals(0.0, score);
	}

	@Test
	public void testGetAllRules() {
		Map<String, String> result = ruleEngine.getAllRules();
		Assert.assertNotNull(result);
	}

	@Test
	public void testModifyRule() {
		RuleRequest request = new RuleRequest();
		request.setRuleId("HotelRule");
		request.setAttribute("score");
		request.setValue("3");
		
		boolean result = ruleEngine.modifyRule(request);
		assert result;
		
		request = new RuleRequest();
		request.setRuleId("HotelRule");
		request.setAttribute("active");
		request.setValue("true");
		
		result = ruleEngine.modifyRule(request);
		assert result;
	}
	
	@Test(expected=ValidationException.class)
	public void testModifyRuleException() {
		RuleRequest request = new RuleRequest();
		request.setRuleId("HotelRule");
		request.setAttribute("score");
		request.setValue("score");
		
		boolean result = ruleEngine.modifyRule(request);
	}

}
