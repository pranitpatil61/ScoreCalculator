package com.agoda.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.agoda.dao.HotelDao;
import com.agoda.rest.beans.Request;

@RunWith(MockitoJUnitRunner.class)
public class HotelRuleTest {

	@InjectMocks
	private HotelRule hotelRule;
	
	@Mock
	private HotelDao hotelDao;
	
	@Test
	public void testExecute() {
		
		Mockito.when(hotelDao.checkHotelPresent(1)).thenReturn(true);
		
		Request req = new Request();
		req.setHotelId(1);
		assert hotelRule.execute(req);
	}

}
