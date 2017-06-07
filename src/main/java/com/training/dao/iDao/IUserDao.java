package com.training.dao.iDao;

import java.util.List;

import com.training.entities.User;

/**
 * @author Olexandr
 *
 */
public interface IUserDao {
	
	/**
	 * @return	list of all users
	 */
	public List<User> findAll();
	
	/**
	 * @param id
	 * @return user
	 */
	public User findEntityById(Integer id);
	
	/**
	 * @param id
	 * @return true if user was marked as deleted
	 */
	public boolean delete(Integer id);
	
	/**
	 * @param user
	 * @return	true if user was marked as deleted
	 */
	public boolean delete(User user);
	
	/**
	 * @param user
	 * @return true if user was inserted into database
	 */
	public boolean create(User user);
	
	/**
	 * @param user
	 * @return true if data in database was updated
	 */
	public User update(User user);
	
	/**
	 * @return list of users which role is driver
	 */
	public List<User> findAllDrivers();
	
	/**
	 * @return list of drivers which are not involved in offer
	 */
	public List<User> findAllFreeDrivers();
	
	/**
	 * @param login
	 * @return	user id user with this login exists
	 */
	public User findEntityByLogin(String login);
}
