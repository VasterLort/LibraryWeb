package by.http.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.web.entity.Author;
import by.http.web.entity.Book;

public interface CatalogService {
	List<Book> getCatalogBooks();
	List<Author> getCatalogAuthors();
	List<Book> searchAuthor(HttpServletRequest req);
	Book getSingleBook(HttpServletRequest req);
	void addAuthor(HttpServletRequest req);
	void deleteBook(HttpServletRequest req);
	void updateBook(HttpServletRequest req);
}
