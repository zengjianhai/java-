package com.briup.pojo;

public class PhoneNumber {

	private String countryCode;
	private String stateCode;
	private String number;

	@Override
	public String toString() {
		return "PhoneNumber [" + countryCode + "-" + stateCode + "-" + number + "]";
	}

	public String getAsString() {
		return countryCode + "-" + stateCode + "-" + number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneNumber(String countryCode, String stateCode, String number) {
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}

	public PhoneNumber(String string) {
		String[] strings=string.split("-");
		countryCode = strings[0];
		stateCode = strings[1];
		number = strings[2];
	}
}
