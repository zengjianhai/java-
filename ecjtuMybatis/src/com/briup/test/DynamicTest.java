package com.briup.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.dynamic.DynamicMapper;
import com.briup.one2marry.Course;
import com.briup.pojo.PhoneNumber;
import com.briup.pojo.Student;
import com.briup.util.MyBatisSqlSessionFactory;

public class DynamicTest {

	@Test
	public void test() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			HashMap<String, Object> map = new HashMap<>();
			map.put("tutorId", 2);
			// Ä£ºý²éÑ¯
			map.put("courseName", "%Java_%");
			map.put("searchBy", "CourseName");
			map.put("searchBy", "Tutor");
			List<Course> list = mapper.searchCourses(map);
			for (Course course : list) {
				System.out.println(course);
			}

			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testForeach() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			HashMap<String, Object> map = new HashMap<>();
			List<Integer> id = new ArrayList<Integer>();
			id.add(1);
			id.add(3);
			id.add(4);
			map.put("tutorIds", id);
			List<Course> list = mapper.searchCoursesByTutors(map);
			for (Course course : list) {
				System.out.println(course);
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			Student s = new Student();
			PhoneNumber pNumber = new PhoneNumber("1111", "1221", "23232");
			s.setStudId(3);
			s.setName("java");
			s.setEmail("asd@as");
			s.setpNumber(pNumber);
			mapper.updateStudent(s);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
