package com.training.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChancgeLanguageCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String lang = request.getParameter("lang");
		String locale = "uk_UA";
		if (lang.equals("en")) {
			locale = "en_US";
		} else if (lang.equals("ja")) {
			locale = "ja_JP";
		}
		request.getSession().setAttribute("language", locale);
		return Pages.INDEX;
	}

}
