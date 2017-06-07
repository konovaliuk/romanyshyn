package com.training.dao.iDao;

import java.util.List;

import com.training.entities.Offer;

/**
 * 
 * @author Olexandr
 *
 */
public interface IOfferDao {
	/**
	 * @return	list of all offers
	 */
	public List<Offer> findAll();
	
	/**
	 * @param id
	 * @return	offer with id
	 */
	public Offer findEntityById(Integer id);
	
	/**
	 * @param id
	 * @return	true if record was deleted
	 */
	public boolean delete(Integer id);
	
	/**
	 * @param offer
	 * @return	true if record was deleted
	 */
	public boolean delete(Offer offer);
	
	/**
	 * @param offer
	 * @return true of object was inserted into database
	 */
	public boolean create(Offer offer);
	
	/**
	 * @param offer
	 * @return	offer after database was updated
	 */
	
	public Offer update(Offer offer);
	
	/**
	 * @param id
	 * @return offer using driver id to find offer
	 */
	public Offer findEntityByDriver(Integer id);
}
