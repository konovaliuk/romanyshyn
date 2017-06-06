package com.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.training.commands.ICommand;

@WebServlet(
		urlPatterns = {"/Controller"},
		name = "Controller"
		)
public class Controller extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(Controller.class);
	private static final long serialVersionUID = 1L;
	private ControllerHelper controllerHelper = ControllerHelper.getInstance();
       
    public Controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		ICommand command = controllerHelper.getCommand(request);
		try {
			page = command.execute(request, response);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.error(e.getMessage());
		}
		
	}

}
