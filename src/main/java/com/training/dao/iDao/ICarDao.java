package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.Car;
/**
 * 
 * @author Olexandr
 *	
 */
public interface ICarDao {
	
	/**
	 * @return	list of all cars which are not deleted
	 */
	public List<Car> findAll();
	
	/**
	 * @param id
	 * @return	car with id
	 */
	public Car findEntityById(Integer id);
	
	/**
	 * Marks car as deleted in database
	 * 
	 * @param id
	 * @return true if car with id was marked as deleted
	 */
	public boolean delete(Integer id);
	
	/**
	 * Simply gets id of car and mark car as deleted
	 * 
	 * @param car
	 * @return	true if car with if was deleted
	 */
	public boolean delete(Car car);
	
	/**
	 * Inserts car record to database
	 * 
	 * @param car
	 * @return	true if car was successfully inserted
	 */
	public boolean create(Car car);
	
	/**
	 * Updates data using car_id as a key
	 * 
	 * @param car
	 * @return	the same car
	 */
	public Car update(Car car);
	
	/**
	 * 
	 * @return Map with car_id as a key and car as a value
	 */
	public Map<Integer, Car> findAllMap();
	
	/**
	 * @return list of cars, which are not assigned to drivers
	 */
	public List<Car> findAllFreeCars();
}
