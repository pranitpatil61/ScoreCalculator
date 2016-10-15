package com.agoda.rest.beans;

public class Response {
	
	private int hotelId;
	private double score;
	
	public Response(int hotelId, double score) {
		super();
		this.hotelId = hotelId;
		this.score = score;
	}
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	
}
