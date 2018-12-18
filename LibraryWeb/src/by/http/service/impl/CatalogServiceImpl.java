package by.http.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.dao.AuthorDao;
import by.http.dao.BookDao;
import by.http.dao.sql.AuthorDaoSqlImpl;
import by.http.dao.sql.BookDaoSqlImpl;
import by.http.service.CatalogService;
import by.http.web.entity.Author;
import by.http.web.entity.Book;

public class CatalogServiceImpl implements CatalogService {
	private BookDao bookDao;
	private AuthorDao authorDao;

	public CatalogServiceImpl() {
		bookDao = new BookDaoSqlImpl();
		authorDao = new AuthorDaoSqlImpl();
	}

	@Override
	public List<Book> getCatalogBooks() {
		return bookDao.getBooks();
	}

	@Override
	public List<Author> getCatalogAuthors() {
		return authorDao.getAuthors();
	}

	@Override
	public Book getSingleBook(HttpServletRequest req) {
		return bookDao.getSingleBook(req);
	}

	@Override
	public void addAuthor(HttpServletRequest req) {
		authorDao.addAuthor(req);
	}

	@Override
	public List<Book> searchAuthor(HttpServletRequest req) {
		return bookDao.searchAuthor(req);
	}

	@Override
	public void deleteBook(HttpServletRequest req) {
		bookDao.deleteBook(req);
	}

	@Override
	public void updateBook(HttpServletRequest req) {
		bookDao.updateBook(req);
	}
}
