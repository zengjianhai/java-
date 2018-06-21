package com.briup.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.extend.ExtendStudentMapper;
import com.briup.pojo.Student;
import com.briup.util.MyBatisSqlSessionFactory;

public class StudentTest2 {

	@Test
	public void testSelect() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			ExtendStudentMapper studentMapper = sqlSession.getMapper(ExtendStudentMapper.class);
			Student s = studentMapper.findStudentWithAddress(3);
			System.out.println(s);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
