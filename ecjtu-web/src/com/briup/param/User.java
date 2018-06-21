package com.briup.param;

public class User {
	private int id;
	private String name;
	private String passwd;
	private String gender;
	private String hobby;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", gender=" + gender + ", hobby=" + hobby
				+ ", age=" + age + "]";
	}
	public User(){}
	public User(int id, String name, String passwd, String gender, String hobby, int age) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.gender = gender;
		this.hobby = hobby;
		this.age = age;
	}
	public User(String name, String passwd, String gender, String hobby, int age) {
		super();
		this.name = name;
		this.passwd = passwd;
		this.gender = gender;
		this.hobby = hobby;
		this.age = age;
	}
	
}
