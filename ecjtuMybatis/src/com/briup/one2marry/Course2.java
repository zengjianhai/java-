package com.briup.one2marry;

import java.util.List;

import com.briup.pojo.Student2;

public class Course2 {
	private Integer id;
	private String courseCode; // �γ̱��
	private String courseName;// �γ�����
	private List<Student2> students;// ѡ��ѧ��
	public Course2(){}
	@Override
	public String toString() {
		return "Course2 [id=" + id + ", courseCode=" + courseCode + ", courseName=" + courseName + "]";
	}
	public Course2(Integer id, String courseCode, String courseName, List<Student2> students) {
		super();
		this.id = id;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.students = students;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student2> getStudents() {
		return students;
	}
	public void setStudents(List<Student2> students) {
		this.students = students;
	}
}
