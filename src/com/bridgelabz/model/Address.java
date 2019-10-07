package com.bridgelabz.model;

public class Address {

	 private String addrss;
	 private String city;
	 private String state;
	 private int zipcode;
 
	 
	public String getAddrss() {
		return addrss;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setAddrss(String addrss) {
		this.addrss = addrss;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "Address [addressLocal=" + addrss+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode+ "]";
	}


}
