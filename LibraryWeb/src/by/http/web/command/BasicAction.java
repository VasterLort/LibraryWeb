package by.http.web.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BasicAction {
	void perfomeAction(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
