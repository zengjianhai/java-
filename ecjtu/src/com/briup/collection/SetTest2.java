package com.briup.collection;

import java.util.Comparator;
import java.util.TreeSet;

public class SetTest2 {

	public static void main(String[] args) {
		Teacher teacher1 = new Teacher("tom", 20);
		Teacher teacher2 = new Teacher("java", 23);
		Teacher teacher3 = new Teacher("niubi", 22);
		/**
		 * 用TreeSet默认是按升序排的,要重写Comparable接口中的compareTo方法
		 */
		TeacherComparator t  = new TeacherComparator();
		TreeSet<Teacher> teachers = new TreeSet<Teacher>(t);
		teachers.add(teacher1);
		teachers.add(teacher2);
		teachers.add(teacher3);
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}

}
//客户化排序,使用的更多,不用操作源码,自定义排序
class TeacherComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Teacher t1 = (Teacher) o1;
		Teacher t2 = (Teacher) o2;
//		if(t1.getAge()>t2.getAge())
//			return -1;
//		else 
//			return 1;
		if(t1.getName().compareTo(t2.getName())>0)return 1;
		else if(t1.getName().compareTo(t2.getName())<0)return -1;
		else return 0;
	}
	
}
class Teacher{
	private String name;
	private int age;

	public Teacher() {
	}

	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + "]";
	}
}
// 自然排序
/*
 * class Teacher implements Comparable{ private String name; private int age;
 * public Teacher(){} public Teacher(String name,int age){ this.name = name;
 * this.age = age; } public String getName() { return name; } public void
 * setName(String name) { this.name = name; } public int getAge() { return age;
 * } public void setAge(int age) { this.age = age; }
 * 
 * @Override public String toString() { return "Teacher [name=" + name +
 * ", age=" + age + "]"; }
 * 
 * @Override public int compareTo(Object o) { Teacher teacher = (Teacher)o;
 * return teacher.name.compareTo(name); } }
 */