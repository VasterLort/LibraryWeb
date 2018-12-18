package by.http.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.dao.AuthorDao;
import by.http.web.entity.Author;

import static by.http.dao.util.DaoConstantStorage.*;

public class AuthorDaoSqlImpl implements AuthorDao {
	@Override
	public List<Author> getAuthors() {
		List<Author> authors = new ArrayList<>();
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(REQUEST_INFO_AUTHOR);
			while (res.next()) {
				authors.add(new Author(res.getInt(COMMAND_ID_GENERAL), res.getString(COMMAND_NAME_AUTHOR),
						res.getString(COMMAND_SURNAME_AUTHOR), res.getInt(COMMAND_AGE_AUTHOR)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return authors;
	}

	@Override
	public void addAuthor(HttpServletRequest req) {
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			PreparedStatement preparedStmt = con.prepareStatement(REQUEST_INSERT_AUTHOR);
			preparedStmt.setString(1, req.getParameter(COMMAND_NAME_AUTHOR));
			preparedStmt.setString(2, req.getParameter(COMMAND_SURNAME_AUTHOR));
			preparedStmt.setInt(3, Integer.parseInt(req.getParameter(COMMAND_AGE_AUTHOR)));
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
