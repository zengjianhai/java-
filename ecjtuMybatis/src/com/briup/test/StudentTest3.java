package com.briup.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.one2one.One2One;
import com.briup.pojo.Student;
import com.briup.reader.Book;
import com.briup.reader.BookService;
import com.briup.util.MyBatisSqlSessionFactory;

public class StudentTest3 {

	@Test
	public void testSelect() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			One2One studentMapper = sqlSession.getMapper(One2One.class);
			Student s = studentMapper.findStudentWithAddress(4);
			System.out.println(s);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test() {
		BookService bService = new BookService();
		Book book = new Book(1,"java","asd",new Date(),100.0);
		bService.addBook(book);
	}

}
