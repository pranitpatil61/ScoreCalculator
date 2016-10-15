package com.agoda.service;


public class Rule {

	private String ruleId;
	private BaseRule ruleInstance;
	private double score;
	private boolean active = Boolean.TRUE;
	
	public Rule(String ruleId, BaseRule ruleInstance, double score,
			boolean active) {
		super();
		this.ruleId = ruleId;
		this.ruleInstance = ruleInstance;
		this.score = score;
		this.active = active;
	}
	
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public BaseRule getRuleInstance() {
		return ruleInstance;
	}
	public void setRuleInstance(BaseRule ruleInstance) {
		this.ruleInstance = ruleInstance;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
