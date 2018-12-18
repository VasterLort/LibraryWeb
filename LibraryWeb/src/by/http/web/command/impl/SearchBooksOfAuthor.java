package by.http.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.service.CatalogService;
import by.http.service.impl.CatalogServiceImpl;
import by.http.web.command.BasicAction;
import by.http.web.entity.Book;

public class SearchBooksOfAuthor implements BasicAction {
private CatalogService catalogService;
	
	@Override
	public void perfomeAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		catalogService = new CatalogServiceImpl();
		List<Book> books = catalogService.searchAuthor(req);
		
		resp.getWriter().println(books);
	}
}
