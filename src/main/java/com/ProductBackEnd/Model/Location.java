package com.ProductBackEnd.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location {
    @Id
    private String id;
    private int locationId;
    private String locationname;
    private String zip_code;


    public Location(int locationId, String locationname, String zip_code) {
		super();
		this.locationId = locationId;
		this.locationname = locationname;
		this.zip_code = zip_code;
	}

	public Location() {
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationname='" + locationname + '\'' +
                ", ZibCode='" + zip_code + '\'' +
                '}';
    }
}
