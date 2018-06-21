package com.briup.pojo;

import java.util.List;

public interface StudentMapper {
	List<Student> findAllStudents(); 
	Student findStudentById(Integer id); 
	void deleteStudentById(Integer id);
	void updataStudentById(Student student);
	void insertStudent(Student student); 
}
