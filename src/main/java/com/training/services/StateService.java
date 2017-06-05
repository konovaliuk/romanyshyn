package com.training.services;

import java.util.List;

import com.training.dao.DaoFactory;
import com.training.entities.State;

public class StateService {
	public static List<State> getAllStates() {
		List<State> states = DaoFactory.getStateDao().findAll();
		return states;
	}
	
	public static State getState(int id) {
		return DaoFactory.getStateDao().findEntityById(id);
	}
}
