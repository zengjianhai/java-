package com.briup.annotation;

import com.briup.pojo.Address;

public class Person {
	private Integer id;
	private String name;
	private Integer age;
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Person(Integer id, String name, Integer age,Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age +", address=["+address+"]]";
	}
	public Person(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
