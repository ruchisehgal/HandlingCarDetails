package com.project.example.vehicle.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.StaleStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.vehicle.dao.CarDetailsDao;
import com.project.example.vehicle.frontendresponsevo.CarJsonResponseVO;
import com.project.example.vehicle.model.CarDetails;

/*This Layer consists the business logic for saving, updating and retrieving the Car Information*/


@Service
@Transactional
public class CarDetailsService {
	private static final String successResponseMessage = "Car Details Added successfully";
	private static final String errorResponseMessage = "Error occured while saving car details";
	private static final String errorResponse = "Error occured while updating Car details";
	@Autowired
	private CarDetailsDao dao;

	public CarJsonResponseVO addCar(CarDetails car) {
		CarJsonResponseVO response = new CarJsonResponseVO();
		try{
			car.setTimeStamp(new Date());
			CarDetails carResult = dao.addCar(car);
			response.setCarDetails(carResult);
			response.setResponseMessage(successResponseMessage);
			response.setRequestTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date()));
			return response;
		} catch(StaleStateException se) {
			se.printStackTrace();
			response.setResponseMessage(errorResponseMessage);
			return null;
		}
		
		
	}
	
	public String updateCarDetails(CarDetails car) {
		try{
			car.setTimeStamp(new Date());
			String message = dao.updateCarDetails(car);
			return message;
		} catch(StaleStateException se) {
			se.printStackTrace();
			return errorResponse;
		}
		
		
	}
	
	public CarJsonResponseVO getCarById(String carID) {
		CarJsonResponseVO carJsonResponse = new CarJsonResponseVO();
		CarDetails carDetails = dao.getCarById(carID);
		carJsonResponse.setRequestTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date()));
		carJsonResponse.setCarDetails(carDetails);
		return carJsonResponse;
	}
	
	public CarJsonResponseVO getCarByCarName(String carName) {
		CarJsonResponseVO carJsonResponse = new CarJsonResponseVO();
		CarDetails carDetails = dao.getCarByCarName(carName);
		carJsonResponse.setRequestTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date()));
		carJsonResponse.setCarDetails(carDetails);
		return carJsonResponse;
	}
	

}
