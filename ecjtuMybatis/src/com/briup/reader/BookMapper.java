package com.briup.reader;

import java.util.List;
import java.util.Map;

public interface BookMapper {
	public void addBook(Book book);
	public void removeBook(Integer id);
	public Book findBookByName(String bookName);
	public Book findBookById(Integer id);
	public List<Book> findAllBooks();
	public List<String> findAllBooksName();
	public int findCountOfBook();
	public void updateBook(Book book);
	public List<Map<String,Object>> findBookNameAndAuthor();
}
