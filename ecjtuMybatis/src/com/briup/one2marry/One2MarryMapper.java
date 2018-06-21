package com.briup.one2marry;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;

import com.briup.pojo.Address;

public interface One2MarryMapper {
	Tutor findTutorById(Integer id);
	/*@Select("SELECT tutor_id, name as tutor_name, email, addr_id FROM tutors where tutor_id=#{id}") 
	@Results( 
	{ 
		@Result(id = true, column = "tutor_id", property = "tutorId"), 
		@Result(column = "tutor_name", property = "name"), 
		@Result(column = "email", property = "email"), 
		@Result(property = "address", column = "addr_id", 
		one = @One(select = "com.briup.one2marry.One2MarryMapper.findAddressById")), 
		@Result(property = "courses", column = "tutor_id", 
		many = @Many(select = "com.briup.one2marry.One2MarryMapper.findCoursesByTutorId")) 
	}) 
	Tutor findTutorById(Integer id);
	
	@Select("select * from address where addr_id=#{id}")
	@ResultMap("com.briup.annotation.AnnotationMapper.AddressResult")
	Address findAddressById(int id);
	

	@Select("select * from courses where tutor_id=#{tutorId}") 
	@Results( 
	{ 
		@Result(id = true, column = "course_id", property = "courseId"), 
		@Result(column = "name", property = "name"), 
		@Result(column = "description", property = "description"), 
		@Result(column = "start_date",property = "startDate"), 
		@Result(column = "end_date",property = "endDate") 
	}) 
	List<Course> findCoursesByTutorId(int tutorId); */
	
	
	@Select("select t.tutor_id, t.name as tutor_name,email,a.addr_id, city, state, zip, country, course_id, c.name,description, start_date, end_date  from tutors t left outer join address a on t.addr_id=a.addr_id left outer join courses c on t.tutor_id=c.tutor_id where t.tutor_id=#{tutorId}") 
	@ResultMap("com.briup.one2marry.One2MarryMapper.TutorResult") 
	Tutor selectTutorById(int tutorId); 
}
