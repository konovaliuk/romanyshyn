package com.training;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.training.commands.ToCustomerFormCommand;
import com.training.commands.ChancgeLanguageCommand;
import com.training.commands.CreateOfferCommand;
import com.training.commands.CreateUserCommand;
import com.training.commands.DeleteCarCommand;
import com.training.commands.DeleteDriverCommand;
import com.training.commands.ToDriverCommand;
import com.training.commands.ToDriversCommand;
import com.training.commands.EmptyCommand;
import com.training.commands.EndOfferCommand;
import com.training.commands.ICommand;
import com.training.commands.LogOutCommand;
import com.training.commands.LoginCommand;
import com.training.commands.NewCarCommand;
import com.training.commands.ToMainPageCommand;
import com.training.commands.ToNewCarCommand;
import com.training.commands.ToNewUserCommand;
import com.training.commands.ProcessOfferCommand;
import com.training.commands.ToCarCommand;
import com.training.commands.ToCarsCommand;
import com.training.commands.ToDriverOfferCommand;
import com.training.commands.ToIndexCommand;
import com.training.commands.ToLoginCommand;
import com.training.commands.ToOfferCommand;
import com.training.commands.ToOffersCommand;
import com.training.commands.UpdateCarCommand;
import com.training.commands.UpdateDriverCommand;
import com.training.properties.PagesProperties;

public class ControllerHelper {
	
	public Map<String, ICommand> postCommands = new LinkedHashMap<>();
	public Map<String, ICommand> getCommands = new LinkedHashMap<>();
	private static PagesProperties rb = PagesProperties.getInstance(); 
	static ControllerHelper instance = null;
	
	private ControllerHelper() {
		postCommands.put(rb.getProperty("login"), new LoginCommand());
		postCommands.put(rb.getProperty("update.driver"), new UpdateDriverCommand());
		postCommands.put(rb.getProperty("update.car"), new UpdateCarCommand());
		postCommands.put(rb.getProperty("delete.car"), new DeleteCarCommand());
		postCommands.put(rb.getProperty("update.driver"), new UpdateDriverCommand());
		postCommands.put(rb.getProperty("process.offer"), new ProcessOfferCommand());
		postCommands.put(rb.getProperty("create.offer"), new CreateOfferCommand());
		postCommands.put(rb.getProperty("create.car"), new NewCarCommand());
		postCommands.put(rb.getProperty("end.offer"), new EndOfferCommand());
		postCommands.put(rb.getProperty("change.language"), new ChancgeLanguageCommand());
		postCommands.put(rb.getProperty("create.user"), new CreateUserCommand());
		postCommands.put(rb.getProperty("delete.driver"), new DeleteDriverCommand());
		
		getCommands.put(rb.getProperty("main"), new ToMainPageCommand());
		getCommands.put(rb.getProperty("login"), new ToLoginCommand());
		getCommands.put(rb.getProperty("index"), new ToIndexCommand());
		getCommands.put(rb.getProperty("logout"), new LogOutCommand());
		getCommands.put(rb.getProperty("drivers"), new ToDriversCommand());
		getCommands.put(rb.getProperty("driver"), new ToDriverCommand());
		getCommands.put(rb.getProperty("cars"), new ToCarsCommand());
		getCommands.put(rb.getProperty("car"), new ToCarCommand());
		getCommands.put(rb.getProperty("offers"), new ToOffersCommand());
		getCommands.put(rb.getProperty("offer"), new ToOfferCommand());
		getCommands.put(rb.getProperty("driver.offer"), new ToDriverOfferCommand());
		getCommands.put(rb.getProperty("customers.form"), new ToCustomerFormCommand());
		getCommands.put(rb.getProperty("car.form"), new ToNewCarCommand());
		getCommands.put(rb.getProperty("new.user"), new ToNewUserCommand());
		
	}
	
	public static ControllerHelper getInstance() {
		if (instance == null) {
			instance = new ControllerHelper();
		}
		return instance;
	}
	
	public ICommand getCommand(HttpServletRequest request) {
		String page = request.getParameter("page");
		if (page != null) {
			return getCommands.get(page);
		}
		String command = request.getParameter("command");
		if (command == null) {
			return new EmptyCommand();
		}
		return postCommands.get(command);
	}
}
