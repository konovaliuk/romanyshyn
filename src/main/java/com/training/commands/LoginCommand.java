package com.training.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.entities.User;
import com.training.properties.RequestParams;
import com.training.services.UserService;

public class LoginCommand implements ICommand {
	private static RequestParams rb = RequestParams.getInstance();
	private static final String LOGIN = rb.getProperty("login");
	private static final String PASSWORD = rb.getProperty("password");
	private static final String USER = rb.getProperty("user");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		User user = UserService.findUserByLogin(login);
		if (user == null) {
			return Pages.ERROR;
		}
		if (password.equals(user.getPassword())) {
			page = Pages.MAIN;
			HttpSession session = request.getSession(true);
			session.setAttribute(USER, user);
		} else {
			request.setAttribute("error", "wrong password or login");
			page = Pages.ERROR;
		}
		return page;
	}

}
