package com.agoda.rest.controller;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.agoda.rest.beans.Request;
import com.agoda.rest.beans.Response;
import com.agoda.service.ScoreService;

@RunWith(MockitoJUnitRunner.class)
public class ScoreControllerTest {

	@InjectMocks
	private ScoreController controller;
	
	@Mock
	private ScoreService scoreService;
	
	@Test
	public void testGetScore() {
		Request request = new Request();
		request.setHotelId(1);
		Mockito.when(scoreService.getScore(request)).thenReturn(3.0);
		Response response = controller.getScore(request);
		
		Response expectedResponse = new Response(1, 3.0);
		
		Assert.assertEquals(expectedResponse.getHotelId(), response.getHotelId());
		Assert.assertEquals(expectedResponse.getScore(), response.getScore());
	}

}
