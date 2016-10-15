package com.agoda.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agoda.rest.beans.RuleRequest;
import com.agoda.service.ConfigService;
import com.agoda.service.RuleEngine;

@Controller
@RequestMapping("/config")
public class ConfigurationController {

	@Autowired
	private RuleEngine ruleEngine;
	
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value="/rules", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Map<String, String> getRules(){
		return ruleEngine.getAllRules();
	}
	
	@RequestMapping(value="/rules", method=RequestMethod.PUT, produces="application/json")
	public @ResponseBody boolean modifyRule(@RequestBody RuleRequest request){
		return ruleEngine.modifyRule(request);
	}
	
	@RequestMapping(value="/hotels/reload", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody boolean reloadHotels(){
		configService.reloadHotels();
		return true;
	}
	
	@RequestMapping(value="/countries/reload", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody boolean reloadCountries(){
		configService.reloadCountries();
		return true;
	}

}
