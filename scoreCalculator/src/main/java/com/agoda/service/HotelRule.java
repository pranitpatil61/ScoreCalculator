package com.agoda.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.agoda.dao.HotelDao;
import com.agoda.rest.beans.Request;

@Service
public class HotelRule extends BaseRule {

	@Autowired
	private HotelDao hotelDao;
	
	@Value("${hotel.rule.default.score}")
	private double hotelRuleScore;
	
	@PostConstruct
	public void init(){
		this.register(RuleType.HotelRule, new Rule(RuleType.HotelRule.getRuleId(),
				this, hotelRuleScore, true));
	}
	
	@Override
	public boolean execute(Request request) {
		return hotelDao.checkHotelPresent(request.getHotelId());
	}

}
