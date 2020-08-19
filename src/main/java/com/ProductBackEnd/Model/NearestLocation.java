package com.ProductBackEnd.Model;

import java.util.List;

public class NearestLocation {
	private List<Zip_codes> zip_codes;

	
	public NearestLocation() {
		super();
	}

	public NearestLocation(List<Zip_codes> zip_codes) {
		super();
		this.zip_codes = zip_codes;
	}

	public List<Zip_codes> getZip_codes() {
		return zip_codes;
	}

	public void setZip_codes(List<Zip_codes> zip_codes) {
		this.zip_codes = zip_codes;
	}

	@Override
	public String toString() {
		return "NearestLocation [zip_codes=" + zip_codes + "]";
	}

}
