package com.training.services;

import java.util.List;

import com.training.dao.DaoFactory;
import com.training.entities.Role;

public class RoleService {
	public static List<Role> getAllRoles() {
		return DaoFactory.getRoleDao().findAll();
	}
	
	public static Role findRoleById(int id) {
		return DaoFactory.getRoleDao().findEntityById(id);
	}
}
