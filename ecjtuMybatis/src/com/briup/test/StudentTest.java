package com.briup.test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.pojo.PhoneNumber;
import com.briup.pojo.Student;
import com.briup.pojo.StudentMapper;
import com.briup.util.MyBatisSqlSessionFactory;

public class StudentTest {

	@Test
	public void testInsert() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
			// test指定运行环境
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();

			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			Student s = new Student(4, "xml", "1239@qq.com", new java.util.Date(),
					new PhoneNumber("400", "800", "8820"));
			studentMapper.insertStudent(s);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelect() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
//			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//			Student s = studentMapper.findStudentById(8);
			//可以不用创建接口，配置文件的namespace名
			Student s=sqlSession.selectOne("com.briup.pojo.StudentMapper.findStudentById", 4);
			System.out.println(s);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdata() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			Student s = new Student(7, "星纪","14214@as",new java.util.Date(),new PhoneNumber("400", "800", "8820"));
			studentMapper.updataStudentById(s);
			System.out.println(s);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.deleteStudentById(9);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectAll() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
//			List<Student> map = sqlSession.selectList("com.briup.pojo.StudentMapper.findAllStudents");
//			for (Student object : map) {
//				System.out.println(object);
//			}
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class); 
			List<Student> students = mapper.findAllStudents(); 
			for (Student object : students) {
				System.out.println(object);
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
