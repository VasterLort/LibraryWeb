package by.http.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.dao.BookDao;
import by.http.web.entity.Book;

import static by.http.dao.util.DaoConstantStorage.*;

public class BookDaoSqlImpl implements BookDao {
	@Override
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(REQUEST_INFO_BOOK);
			while (res.next()) {
				books.add(new Book(res.getInt(COMMAND_ID_GENERAL), res.getString(COMMAND_NAME_BOOK)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}

	@Override
	public Book getSingleBook(HttpServletRequest req) {
		Book book = null;
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(REQUEST_INFO_BOOK);
			while (res.next()) {
				if (Integer.parseInt(req.getParameter(COMMAND_ID_BOOK)) == res.getInt(COMMAND_ID_GENERAL)) {
					book = new Book(res.getInt(COMMAND_ID_GENERAL), res.getString(COMMAND_NAME_BOOK));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (book == null)
			book = new Book(Integer.parseInt(req.getParameter(COMMAND_ID_BOOK)), COMMAND_EMPTY_VALUE_BOOK);

		return book;
	}

	@Override
	public List<Book> searchAuthor(HttpServletRequest req) {
		List<Book> books = new ArrayList<>();
		int count = 1;
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt1 = con.createStatement();
			ResultSet res1 = stmt1.executeQuery(REQUEST_ALL_INFORMATION);
			while (res1.next()) {
				if (Integer.parseInt(req.getParameter(COMMAND_ID_AUTHOR)) == res1.getInt(COMMAND_ID_AUTHOR)) {
					books.add(new Book(count, res1.getString(COMMAND_NAME_BOOK)));
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (books.isEmpty())
			books.add(new Book(Integer.parseInt(req.getParameter(COMMAND_ID_AUTHOR)), COMMAND_EMPTY_VALUE_AUTHOR));

		return books;
	}
	
	@Override
	public void deleteBook(HttpServletRequest req) {
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			PreparedStatement preparedStmt = con.prepareStatement(REQUEST_DELETE_BOOK);
			preparedStmt.setInt(1, Integer.parseInt(req.getParameter(COMMAND_ID_BOOK)));
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(HttpServletRequest req) {
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			PreparedStatement preparedStmt = con.prepareStatement(REQUEST_UPDATE_BOOK);
			preparedStmt.setString(1, req.getParameter(COMMAND_NAME_BOOK));
			preparedStmt.setInt(2, Integer.parseInt(req.getParameter(COMMAND_ID_BOOK)));
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
