package com.project.example.vehicle.frontendresponsevo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.project.example.vehicle.model.CarDetails;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CarJsonResponseVO {

	private CarDetails carDetails;
	private String requestTimestamp;
	
	private String responseMessage;
	public CarDetails getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}
	public String getRequestTimestamp() {
		return requestTimestamp;
	}
	public void setRequestTimestamp(String requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
