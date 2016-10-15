package com.agoda.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agoda.rest.beans.Request;
import com.agoda.rest.beans.Response;
import com.agoda.service.ScoreService;

@RestController
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Response getScore(@RequestBody Request request){
		
		double score = scoreService.getScore(request);
		
		return createResponse(request.getHotelId(), score);
	}
	
	private Response createResponse(int hotelId, double score){
		return new Response(hotelId, score);
	}
	
}
