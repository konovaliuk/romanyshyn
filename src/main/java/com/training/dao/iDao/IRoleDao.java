package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.Role;

/**
 * @author Olexandr
 *
 */
public interface IRoleDao {

	/**
	 * @return list of all roles
	 */
	public List<Role> findAll();

	/**
	 * @return Map, where id is a key, role is a value
	 */
	public Map<Integer, Role> findAllMap();

	/**
	 * @param id
	 * @return	role
	 */
	public Role findEntityById(Integer id);

	/**
	 * @param id
	 * @return true if record was deleted
	 */
	public boolean delete(Integer id);

	/**
	 * @param role
	 * @return true if record was deleted
	 */
	public boolean delete(Role role);

	/**
	 * @param role
	 * @return true if role was inserted to database
	 */
	public boolean create(Role role);

	/**
	 * @param role
	 * @return role after database was updated
	 */
	public Role update(Role role);

}
