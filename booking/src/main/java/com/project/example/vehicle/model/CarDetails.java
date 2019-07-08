package com.project.example.vehicle.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Cars_Detail_Table", uniqueConstraints = {@UniqueConstraint(columnNames = { "carNumber" })})
public class CarDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5143471244988670532L;
	@Id
	@GeneratedValue
	private int car_id_seq;
	@NotNull
	private String carId;
	@NotNull
	private String carName;
	@NotNull
	private String carOwnerName;
	@NotNull
	private String carNumber;
	
	@NotNull
	private String carOwnerContact;
	
	@NotNull
	private String carOwnerAddress;
	
	private String carOwnerRefree;
	private Date timeStamp;
	
	public int getCar_id_seq() {
		return car_id_seq;
	}
	public void setCar_id_seq(int car_id_seq) {
		this.car_id_seq = car_id_seq;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarOwnerName() {
		return carOwnerName;
	}
	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarOwnerContact() {
		return carOwnerContact;
	}
	public void setCarOwnerContact(String carOwnerContact) {
		this.carOwnerContact = carOwnerContact;
	}
	public String getCarOwnerAddress() {
		return carOwnerAddress;
	}
	public void setCarOwnerAddress(String carOwnerAddress) {
		this.carOwnerAddress = carOwnerAddress;
	}
	public String getCarOwnerRefree() {
		return carOwnerRefree;
	}
	public void setCarOwnerRefree(String carOwnerRefree) {
		this.carOwnerRefree = carOwnerRefree;
	}
	public String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(timeStamp);
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public CarDetails(int car_id_seq, String carId, String carName, String carOwnerName, String carNumber,
			String carOwnerContact, String carOwnerAddress, String carOwnerRefree, Date timeStamp) {
		super();
		this.car_id_seq = car_id_seq;
		this.carId = carId;
		this.carName = carName;
		this.carOwnerName = carOwnerName;
		this.carNumber = carNumber;
		this.carOwnerContact = carOwnerContact;
		this.carOwnerAddress = carOwnerAddress;
		this.carOwnerRefree = carOwnerRefree;
		this.timeStamp = timeStamp;
	}
	public CarDetails() {
		super();
	}
	
	

	

}
