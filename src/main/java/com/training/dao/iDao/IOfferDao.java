package com.training.dao.iDao;

import java.util.List;

import com.training.entities.Offer;


public interface IOfferDao {
	public List<Offer> findAll();
	public Offer findEntityById(Integer id);
	public boolean delete(Integer id);
	public boolean delete(Offer offer);
	public boolean create(Offer offer);
	public Offer update(Offer offer);
	Offer findEntityByDriver(Integer id);
}
