package com.project.example.vehicle.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.example.vehicle.frontendresponsevo.CarJsonResponseVO;
import com.project.example.vehicle.model.CarDetails;
import com.project.example.vehicle.service.CarDetailsService;

/*This Controller deals with Adding/Retrieving a 
 * Car information from the database 
 */

@RestController
@RequestMapping("/vehiclemanagement")
public class CarDetailsController {
	@Autowired
	private CarDetailsService service;
	
	//This serves as the entry point to add/save Car Details
	@PostMapping("/addCar")
	public CarJsonResponseVO updateStatus(@RequestBody @Valid CarDetails car) {
		CarJsonResponseVO responseVO = service.addCar(car);
		return responseVO;

	}
	
	/*This serves as the entry point to update existing car details
	* Status 204- Indicating that update Failed/
	 * Status 400 -Indicating erroneous input JSON*/
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/updateCarInformation")
	public ResponseEntity  updateCcarDetails(@RequestBody @Valid CarDetails carDetails) {
		
		try{
		String responseMesssage = service.updateCarDetails(carDetails);
		return new ResponseEntity<String>(responseMesssage, HttpStatus.CREATED);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT); 
		}
		
	}
	
	//This serves as the entry point to retrieve a car information by id
	@GetMapping("/getCarInformationById/carId/{carID}")
	public CarJsonResponseVO retrieveCarInfoById(@PathVariable String carID) {
		CarJsonResponseVO carDetails = service.getCarById(carID);
		return carDetails;
	}
	//This serves as an entry point to retrieve Car information by its name
	@GetMapping("/getCarInformationByName/carName/{carName}")
	public CarJsonResponseVO retrieveCarInfoByName(@PathVariable String carName) {
		CarJsonResponseVO carDetails = service.getCarByCarName(carName);
		return carDetails;
	}

}
