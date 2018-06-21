package com.briup.dynamic;

import java.util.List;
import java.util.Map;

import com.briup.one2marry.Course;
import com.briup.pojo.Student;
public interface DynamicMapper {
	List<Course> searchCourses(Map<String, Object> map); 
	List<Course> searchCoursesByTutors(Map<String, Object> map); 
	void updateStudent(Student student);
}
