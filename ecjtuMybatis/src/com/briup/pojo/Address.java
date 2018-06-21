package com.briup.pojo;

public class Address {
	private Integer addrId;
	private String city;
	private String state;
	private String zip;
	private String country;
	public Address(){}
	public Address(Integer addrId, String city, String state, String zip, String country) {
		super();
		this.addrId = addrId;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country="
				+ country + "]";
	}
	public Integer getAddrId() {
		return addrId;
	}
	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
