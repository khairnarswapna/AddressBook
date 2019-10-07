package com.bridgelabz.model;

public class Person { 

	private String firstname;
	private String lastname;
	private Address addressObj;
	private Long mobileNO;
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public Address getAddressObj() {
		return addressObj;
	}
	public Long getMobileNO() {
		return mobileNO;
	}
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddressObj(Address addressObj) {
		this.addressObj = addressObj;
	}
	public void setMobileNO(Long mobileNO) {
		this.mobileNO = mobileNO;
		
	}
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", addressObj=" + addressObj + ", mobileNO="
				+ mobileNO+ "]";
	}
	

}
