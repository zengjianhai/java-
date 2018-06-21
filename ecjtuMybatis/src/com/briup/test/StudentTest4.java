package com.briup.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.many2many.Many2ManyMapper;
import com.briup.one2marry.Course;
import com.briup.one2marry.Course2;
import com.briup.one2marry.One2MarryMapper;
import com.briup.one2marry.Tutor;
import com.briup.pojo.Student2;
import com.briup.util.MyBatisSqlSessionFactory;

public class StudentTest4 {

	@Test
	public void testOne2One() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			One2MarryMapper mapper = sqlSession.getMapper(One2MarryMapper.class);
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(System.in));
			Tutor s = mapper.findTutorById(1);
			System.out.println(s);
			List<Course> courses = s.getCourses();
			for (Course course : courses) {
				System.out.println(course);
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMany2Many() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			Many2ManyMapper mapper = sqlSession.getMapper(Many2ManyMapper.class);
//			Student2 student2 = new Student2();
//			for (int i = 0; i < 3; i++) {
//				student2.setId(1);
//				student2.setName("java");
//				int d = (int) (Math.random() * 2);
//				if (d % 2 == 0) {
//					student2.setGender("female");
//				} else {
//					student2.setGender("male");
//				}
//				student2.setGrade("´óÈý");
//				student2.setMajor("Èí¼þ");
//				mapper.insertStudent(student2);
//			}
			Student2 student2 = mapper.getStudentById(3);
			System.out.println(student2);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testMany2ManyCourse() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			Many2ManyMapper mapper = sqlSession.getMapper(Many2ManyMapper.class);
//			Course2 course = new Course2(1,"0001","java",null);
//			Course2 course2 = new Course2(2,"0002","php",null);
//			Course2 course3 = new Course2(3,"0003","oralce",null);
//			mapper.insertCourse(course);
//			mapper.insertCourse(course2);
//			mapper.insertCourse(course3);
			
			
//			Student2 student2 = mapper.getStudentById(3);
//			Course2 course = mapper.getCourseById(7);
//			mapper.studentSelectCourse(student2, course);
			
//			List<Student2> list = mapper.getStudentByIdOnCondition(20);
//			for (Student2 student2:list) {
//				System.out.println(student2);
//			}
			
			
			Student2 student = mapper.getStudentByIdWithCourses(3);
			System.out.println(student);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
