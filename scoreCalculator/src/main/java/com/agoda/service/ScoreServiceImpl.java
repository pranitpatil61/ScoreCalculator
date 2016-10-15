package com.agoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agoda.rest.beans.Request;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private RuleEngine ruleEngine;
	
	@Override
	public double getScore(Request request) {
		return ruleEngine.executeRulesForScore(request, RuleType.HotelRule, RuleType.CountryRule);
	}

}