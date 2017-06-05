package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.Car;

public interface ICarDao {
	public List<Car> findAll();
	public Car findEntityById(Integer id);
	public boolean delete(Integer id);
	public boolean delete(Car car);
	public boolean create(Car car);
	public Car update(Car car);
	public Map<Integer, Car> findAllMap();
	List<Car> findAllFreeCars();
}
