package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.State;

/**
 * @author Olexandr
 *
 */
public interface IStateDao {
	
	/**
	 * @return list of all states
	 */
	public List<State> findAll();
	
	/**
	 * @param id
	 * @return state
	 */
	public State findEntityById(Integer id);
	
	/**
	 * @param id
	 * @return true if state was deleted
	 */
	public boolean delete(Integer id);
	
	/**
	 * @param state
	 * @return true if state was deleted
	 */
	public boolean delete(State state);
	/**
	 * @param state
	 * @return true if state was inserted
	 */
	public boolean create(State state);
	
	/**
	 * @param state
	 * @return state after database was updated
	 */
	public State update(State state);
	
	/**
	 * @return map where key is id, value is state
	 */
	public Map<Integer, State> findAllMap();
}
