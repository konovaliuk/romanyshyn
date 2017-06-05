package com.training.dao;

import com.training.dao.daoImpl.CarDao;
import com.training.dao.daoImpl.CustomerDao;
import com.training.dao.daoImpl.OfferDao;
import com.training.dao.daoImpl.RoleDao;
import com.training.dao.daoImpl.StateDao;
import com.training.dao.daoImpl.UserDao;

public abstract class DaoFactory {
	
	public static CarDao getCarDao() {
		return CarDao.getInstance();
	}
	public static UserDao getUserDao() {
		return UserDao.getInstance();
	}
	public static RoleDao getRoleDao() {
		return RoleDao.getInstance();
	}
	public static StateDao getStateDao() {
		return StateDao.getInstance();
	}
	public static CustomerDao getCustomerDao() {
		return CustomerDao.getInstance();
	}	
	public static OfferDao getOfferDao() {
		return OfferDao.getInstance();
	}
}
