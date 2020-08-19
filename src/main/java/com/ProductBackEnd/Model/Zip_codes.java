package com.ProductBackEnd.Model;

public class Zip_codes {
	
	 private String zip_code;
	 private double  distance;
     private String   city;
     private String   state;
     
     
	public Zip_codes() {
		super();
	}
	
	
	public Zip_codes(String zip_code) {
		super();
		this.zip_code = zip_code;
	}


	public Zip_codes(String zip_code, double distance, String city, String state) {
		super();
		this.zip_code = zip_code;
		this.distance = distance;
		this.city = city;
		this.state = state;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Zip_codes [zip_code=" + zip_code + ", distance=" + distance + ", city=" + city + ", state=" + state
				+ "]";
	}

//
//	@Override
//	public String toString() {
//		return "Zip_codes [zip_code=" + zip_code + "]";
//	}
//     
     
}
