package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.State;

public interface IStateDao {
	public List<State> findAll();
	public State findEntityById(Integer id);
	public boolean delete(Integer id);
	public boolean delete(State state);
	public boolean create(State state);
	public State update(State state);
	public Map<Integer, State> findAllMap();
}
