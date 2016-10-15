package com.agoda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.agoda.rest.beans.Request;

public abstract class BaseRule {

	@Autowired
	private RuleEngineImpl ruleEngine;
	
	/**
	 * Executes the corresponding rule on the basis of 
	 * required attributes from request 
	 * 
	 * @param request
	 * @return boolean
	 */
	public abstract boolean execute(Request request);
	
	public void register(RuleType ruleType, Rule rule) {
		ruleEngine.registerRule(ruleType, rule);
	}
}
