package com.training.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.PagesMapping;
import com.training.entities.Role;
import com.training.entities.RoleEnum;
import com.training.entities.User;
import com.training.properties.Properties;

@WebFilter(urlPatterns = { "/Controller", "/jsp/*" })
public class SessionFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		String page = (String) req.getParameter("page");
		String command = (String) req.getParameter("command");
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			user = new User();
			Role role = new Role();
			role.setName(RoleEnum.UNREGISTERED.name().toLowerCase());
			user.setRole(role);
			req.getSession().setAttribute("user", user);
		}
		page = page == null ? "null" : page;
		command = command == null ? "null" : command;
		
		List<String> avaiablePage = PagesMapping.PAGES_MAP.get(user.getRole().getName());
		if (avaiablePage.contains(command) || avaiablePage.contains(page)) {
			chain.doFilter(req, res);
			return;
		} else {
			res.sendRedirect("/WEBmaven/Controller?page=login");
			return;
		}		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
