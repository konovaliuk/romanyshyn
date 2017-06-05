package com.training.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.User;
import com.training.properties.RequestParams;
import com.training.services.UserService;

public class CreateUserCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String FIRST_NAME = rb.getProperty("first.name");
	private static final String LAST_NAME = rb.getProperty("last.name");
	private static final String LOGIN = rb.getProperty("login");
	private static final String PASSWORD = rb.getProperty("password");
	private static final String ROLE_ID = rb.getProperty("role.id");

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		int roleId = Integer.valueOf(request.getParameter(ROLE_ID));
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setPassword(password);
		user.setRoleId(roleId);
		UserService.createUser(user);
		return Pages.HOME;
	}

}
