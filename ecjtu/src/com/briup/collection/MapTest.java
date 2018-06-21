package com.briup.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		// Map<Student2,Integer> map = new HashMap<Student2,Integer>();

		ComparatorTest test = new ComparatorTest();
		Map<Student2, Integer> map = new TreeMap<Student2, Integer>(test);
		Student2 s1 = new Student2("hello", 20, 90);
		Student2 s2 = new Student2("world", 21, 90);
		Student2 s3 = new Student2("tom", 18, 90);
		Student2 s4 = new Student2("java", 22, 79);
		Student2 s5 = new Student2("php", 18, 82);
		map.put(s1, s1.getScore());
		map.put(s2, s2.getScore());
		map.put(s3, s3.getScore());
		map.put(s4, s4.getScore());
		map.put(s5, s5.getScore());
		Set<Student2> set = map.keySet();
		for (Student2 object : set) {
			Object value = map.get(object);
			System.out.println(object.getName() + ":" + value);
		}
	}

}

class ComparatorTest implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student2 s1 = (Student2) o1;
		Student2 s2 = (Student2) o2;
		//每一种情况都要理清楚
		if (s1.getScore() < s2.getScore())
			return -1;
		else if (s1.getScore() > s2.getScore())
			return 1;
		else 
			if (s1.getName().compareTo(s2.getName()) < 0)
				return -1;
			else if (s1.getName().compareTo(s2.getName()) > 0)
				return 1;
			else
				return 0;

	}

}

class Student2 {
	private String name;
	private int age;
	private int score;

	public Student2() {
	}

	public Student2(String name, int age, int score) {
		this.name = name;
		this.age = age;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student2 [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	/*
	 * public boolean equals(Object o){ Student2 student2 = (Student2)o; return
	 * name.equals(student2.name)&&(age==student2.age); } public int hashCode(){
	 * return name.hashCode()+age; }
	 */
	/*
	 * @Override public int compareTo(Object o) { Student2 student2 =
	 * (Student2)o; return score-student2.score; }
	 */
}