package by.http.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.command.CommandManager;

import static by.http.web.util.WebConstantStorage.*;

/**
 * Servlet implementation class MySecondServlet
 */
@WebServlet("/MySecondServlet")
public class MySecondServlet extends HttpServlet {
	public MySecondServlet() {
		super();
		System.out.println("constructor");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("Service");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destroy");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Initialization");
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String action = req.getParameter(REQ_PARAM_ACTION);

		if (action != null) {
			BasicAction basicAction = CommandManager.defineAction(action);
			basicAction.perfomeAction(req, resp);
		}
	}
}
