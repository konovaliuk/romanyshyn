package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Role;
import com.training.properties.RequestParams;
import com.training.services.RoleService;

public class ToNewUserCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String ROLES = rb.getProperty("roles");

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Role> roles = RoleService.getAllRoles();
		request.setAttribute(ROLES, roles);
		return Pages.NEW_USER;
	}

}
