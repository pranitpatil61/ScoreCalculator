package com.agoda.service;

import java.util.Map;

import com.agoda.rest.beans.Request;
import com.agoda.rest.beans.RuleRequest;

public interface RuleEngine {
	
	/**
	 * Registers Rules with rule engine and stores all rules in rulestore
	 * @param ruleType
	 * @param rule
	 */
	public void registerRule(RuleType ruleType, Rule rule);

	/**
	 * Specialized service to execute specified rules 
	 * Rules will be executed as per order in which they are specified.
	 * 
	 * @param request
	 * @param rules
	 * @return score
	 */
	public double executeRulesForScore(Request request, RuleType... rules);
	
	/**
	 * Returns all rules registered with RuleEngine
	 * 
	 */
	public Map<String, String> getAllRules();
	
	/**
	 * Modifies rule
	 * 
	 * @param RuleRequest
	 * attribute - score - modifies score
	 * attribute - active - activates / deactivates rules
	 * 
	 * @return
	 */
	public boolean modifyRule(RuleRequest request);

}
