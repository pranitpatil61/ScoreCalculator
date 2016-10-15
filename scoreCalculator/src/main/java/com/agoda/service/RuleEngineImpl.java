package com.agoda.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.agoda.exception.ValidationException;
import com.agoda.rest.beans.Request;
import com.agoda.rest.beans.RuleRequest;

@Component
public class RuleEngineImpl implements RuleEngine{

	private static Logger logger = LoggerFactory.getLogger(RuleEngineImpl.class);
	
	private Map<RuleType, Rule> ruleStore = new HashMap<>();

	@Override
	public void registerRule(RuleType ruleType, Rule rule) {
		ruleStore.put(ruleType, rule);
	}

	@Override
	public double executeRulesForScore(Request request, RuleType... rules) {
		double score = 0;

		for (RuleType ruleType : rules) {
			try {
				Rule rule = ruleStore.get(ruleType);
				if (!rule.isActive())
					continue;

				boolean ruleResult = rule.getRuleInstance().execute(request);

				if (ruleResult) {
					score = Math.max(score, rule.getScore());
				}
			} catch (Exception e) {
				logger.error(
						"Exception Occured while executing rule. Setting score to 0.",
						e.getMessage(), e.getStackTrace());
				score = Math.max(score, 0);
			}
		}

		return score;
	}
	
	@Override
	public Map<String, String> getAllRules() {
		Map<String, String> rules = new LinkedHashMap<>();
		
		for(Rule rule : ruleStore.values()){
			String ruleStatus = rule.isActive()? "Active" : "Not Active";
			rules.put(rule.getRuleId(), "This Rule is "+ ruleStatus
					+" and Score is "+rule.getScore());
		}
		
		return rules;
	}
	
	@Override
	public boolean modifyRule(RuleRequest request) {
		
		try {
			Rule rule = this.ruleStore.get(RuleType.fromId(request.getRuleId()));
			switch (request.getAttribute()) {
			case "score":
				rule.setScore(Double.valueOf(request.getValue()));
				break;

			case "active":
				rule.setActive(Boolean.parseBoolean(request.getValue()));
				break;

			default:
				return false;
			}
			ruleStore.put(RuleType.fromId(request.getRuleId()), rule);
			return true;
		} catch (Exception e) {
			logger.error("Error occured while updating rule ", e.getMessage() , e);
			throw new ValidationException("Error occured while updating rule "+request.getRuleId() , e.getMessage());
		}
	}
	
	public void setRuleStore(Map<RuleType, Rule> ruleStore) {
		this.ruleStore = ruleStore;
	}
}
