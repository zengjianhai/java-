package com.briup.collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Student student = new Student("tom", 22, "Ò»°à");
		Student student2 = new Student("tom", 22, "¶þ°à");
		Set<Student> set = new HashSet<Student>();
		set.add(student);
		set.add(student2);
		for (Student students : set) {
			System.out.println(students);
		}
	}
}

class Student {
	private String name;
	private int age;
	private String clas;
	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public Student() {
	}

	public Student(String name, int age,String clas) {
		this.name = name;
		this.age = age;
		this.clas = clas;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", class="+clas+"]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean equals(Object o) {
		Student student = (Student) o;
		return this.name.equals(student.name) && this.age == student.age;
	}

	public int hashCode() {
		return name.hashCode() + age;
	}
}