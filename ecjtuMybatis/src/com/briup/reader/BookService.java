package com.briup.reader;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.briup.pojo.PhoneNumber;
import com.briup.pojo.Student;
import com.briup.pojo.StudentMapper;
import com.briup.util.MyBatisSqlSessionFactory;

public class BookService {
	public void addBook(Book book){
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			bookMapper.addBook(book);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeBook(Integer id){
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			bookMapper.removeBook(id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Book findBookByName(String bookName){
		Book book = null;
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			book = bookMapper.findBookByName(bookName);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book findBookById(Integer id){
		Book book = null;
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			book = bookMapper.findBookById(id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public List<Book> findAllBooks(){
		List<Book> list = null;
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			list = bookMapper.findAllBooks();
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> findAllBooksName(){
		List<String> list = null;
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			list = bookMapper.findAllBooksName();
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int findCountOfBook(){
		int count = 0;
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			count = bookMapper.findCountOfBook();
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void updateBook(Book book){
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			bookMapper.updateBook(book);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String,Object>> findBookNameAndAuthor(){
		List<Map<String, Object>> list=null;
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			list = bookMapper.findBookNameAndAuthor();
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
