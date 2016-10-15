package com.agoda.service;

/**
 * Define New Rules and their ids here.
 *
 */
public enum RuleType {
	HotelRule("HotelRule"),
	CountryRule("CountryRule");
	
	private String ruleId;
	
	RuleType(String id) {
		this.ruleId = id;
	}
	
	public String getRuleId() {
		return ruleId;
	}
	
	public static RuleType fromId(String id){
		for(RuleType ruleType : values()){
			if(ruleType.getRuleId().equals(id))
				return ruleType;
		}
		throw new IllegalArgumentException("Invalid Rule.!");
	}
}
