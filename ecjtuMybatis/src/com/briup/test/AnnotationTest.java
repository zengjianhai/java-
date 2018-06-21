package com.briup.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.annotation.AnnotationMapper;
import com.briup.annotation.Person;
import com.briup.one2marry.Course;
import com.briup.one2marry.One2MarryMapper;
import com.briup.one2marry.Tutor;
import com.briup.pojo.Address;
import com.briup.util.MyBatisSqlSessionFactory;

public class AnnotationTest {

	@Test
	public void test() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
//		mapper.insertPerson(new Person(1, "√Ù", 19));
		session.commit();
	}
	@Test
	public void testUpdate() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
//		mapper.updatePerson(new Person(21, "tom", 20));
		session.commit();
	}
	@Test
	public void testDelete() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		mapper.deleteStudent(1);
		session.commit();
	}
	@Test
	public void testSelete() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
//		List<Person> list  = mapper.findAllPersons();
//		for (Person person2 : list) {
//			System.out.println(person2);
//		}
//		Address address = mapper.findAddressById(1);
//		System.out.println(address);
		Person person = mapper.selectPersonWithAddress(21);
		System.out.println(person);
		session.commit();
	}
	@Test
	public void testOne2Many() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		One2MarryMapper mapper = session.getMapper(One2MarryMapper.class);
//		Address address = mapper.findAddressById(1);
//		System.out.println(address);
//		List<Course> list = mapper.findCoursesByTutorId(2);
//		for (Course course : list) {
//			System.out.println(course);
//		}
		Tutor tutor = mapper.selectTutorById(2);
		System.out.println(tutor);
		session.commit();
	}

}
