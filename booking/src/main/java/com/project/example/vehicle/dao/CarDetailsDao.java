package com.project.example.vehicle.dao;


import com.project.example.vehicle.model.CarDetails;



/*The Data interface layer providing Abstraction to the underlying database 
 * and sending Back the requested information to the Service layer*/


public interface CarDetailsDao {
	
	public CarDetails addCar(CarDetails car);
	
	public String updateCarDetails(CarDetails car);
	
	public CarDetails getCarById(String carID);
	
	public CarDetails getCarByCarName(String carName);


}
