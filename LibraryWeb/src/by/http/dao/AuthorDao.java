package by.http.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.web.entity.Author;

public interface AuthorDao {
	List<Author> getAuthors();
	void addAuthor(HttpServletRequest req);
}
