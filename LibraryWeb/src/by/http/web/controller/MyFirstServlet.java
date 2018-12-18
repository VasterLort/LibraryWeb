package by.http.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	{
		System.out.println("Hello from servlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");

		if (login.equals("user")) {
			System.out.println("user role");
			resp.getWriter().println("user");
		} else if (login.equals("admin")) {
			System.out.println("admin role");
			resp.getWriter().println("admin");
		} else {
			System.out.println("guest role");
			resp.getWriter().println("<h1 style = 'color:red'>guest</h1>");
		}
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Initialization");
	}
}
