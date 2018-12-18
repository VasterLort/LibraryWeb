package by.http.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.web.entity.Book;

public interface BookDao {
	List<Book> getBooks();
	Book getSingleBook(HttpServletRequest req);
	List<Book> searchAuthor(HttpServletRequest req);
	void deleteBook(HttpServletRequest req);
	void updateBook(HttpServletRequest req);
}
