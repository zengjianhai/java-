package com.briup.pojo;

import java.util.Date;

public class Student {
	private Integer studId;
	private String name;
	private String email;
	private Date dob;
	private PhoneNumber pNumber;
	private Address address;
	public Student(Integer studId, String name, String email, Date dob, PhoneNumber pNumber, Address address) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.pNumber = pNumber;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PhoneNumber getpNumber() {
		return pNumber;
	}

	public void setpNumber(PhoneNumber pNumber) {
		this.pNumber = pNumber;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", pNumber="
				+ pNumber + ", address=" + address + "]";
	}

	public Student(Integer studId, String name, String email, Date dob, PhoneNumber pNumber) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.pNumber = pNumber;
	}

	public Student(Integer studId, String name, String email) {
		this.studId = studId;
		this.name = name;
		this.email = email;
	}

	public Student(Integer studId, String name, String email, Date dob) {
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
