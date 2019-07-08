package com.project.example.vehicle.dao;


import javax.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleStateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.example.vehicle.model.CarDetails;

/*This class provides the implementation for CarDetailsDao interface*/
@Repository
public class CarDetailsDaoImpl implements CarDetailsDao {
	private static final String successResponse = "Updated Successfully";
	private static final String errorResponse = "Error occured while updating Car details";
	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException ex) {
			session = factory.openSession();
		}
		return session;
	}

	@Override
	public CarDetails addCar(CarDetails car) {
		try {
			getSession().save(car);
			return car;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			return null;
		}
		
	}

	@Override
	public String updateCarDetails(CarDetails car) {
		try{
			getSession().update(car);
			return successResponse;
			}catch(PersistenceException pe) {
				pe.printStackTrace();
				return errorResponse;
			}catch (StaleStateException se) {
				se.printStackTrace();
				return errorResponse;
			}
	}

	@Override
	public CarDetails getCarById(String carId) {
		CarDetails carDetails = (CarDetails) getSession().createCriteria(CarDetails.class).add(Restrictions.eq("carId", carId)).uniqueResult();
		return carDetails;
	}

	@Override
	public CarDetails getCarByCarName(String carName) {
		CarDetails carDetails = (CarDetails) getSession().createCriteria(CarDetails.class).add(Restrictions.eq("carName", carName)).uniqueResult();
		return carDetails;
	}

}
