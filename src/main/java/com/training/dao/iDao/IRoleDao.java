package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.Role;

public interface IRoleDao {

	List<Role> findAll();

	Map<Integer, Role> findAllMap();

	Role findEntityById(Integer id);

	boolean delete(Integer id);

	boolean delete(Role role);

	boolean create(Role role);

	Role update(Role role);

}
