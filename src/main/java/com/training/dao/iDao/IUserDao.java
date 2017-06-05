package com.training.dao.iDao;

import java.util.List;

import com.training.entities.User;

public interface IUserDao {
	public List<User> findAll();
	public User findEntityById(Integer id);
	public boolean delete(Integer id);
	public boolean delete(User user);
	public boolean create(User user);
	public User update(User user);
	List<User> findAllDrivers();
	List<User> findAllFreeDrivers();
	User findEntityByLogin(String login);
}
