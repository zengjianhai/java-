package com.briup.xml;

public class Employee {
	private String name;
	private int id;
	private int age;
	private String gender;
	private int salary;
	private String depName;

	public Employee() {
	}

	public Employee(String name, int id, int age, String gender, int salary, String depName) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
		this.salary = salary;
		this.depName = depName;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", age=" + age + ", gender=" + gender + ", salary=" + salary
				+ ", depName=" + depName + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}
}
