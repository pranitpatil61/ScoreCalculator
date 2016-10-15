package com.agoda.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.agoda.dao.CountryDao;
import com.agoda.rest.beans.Request;

@Service
public class CountryRule extends BaseRule {

	@Autowired
	private CountryDao countryDao;
	
	@Value("${country.rule.default.score}")
	private double countryRuleScore;
	
	@PostConstruct
	public void init(){
		this.register(RuleType.CountryRule, new Rule(RuleType.CountryRule.getRuleId(),
				this, countryRuleScore, true));
	}
	
	@Override
	public boolean execute(Request request) {
		return countryDao.checkCountryPresent(request.getCountryId());
	}

}
