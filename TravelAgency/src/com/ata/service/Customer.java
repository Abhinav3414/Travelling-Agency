package com.ata.service;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

/**
 * This interface is used to declare various methods for Customer
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public interface Customer 
{
	
	/**
	 * @param vehicleType Function Parameter
	 * @return ArrayList
	 */
	ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);
	
	/**
	 * @param noOfSeats Function Parameter
	 * @return ArrayList
	 */
	ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats);
	
	/**
	 * @return ArrayList
	 */
	ArrayList<RouteBean> viewAllRoutes();
	
	/**
	 * @param reservationBean Function Parameter
	 * @return String
	 */
	String bookVehicle(ReservationBean reservationBean);
	
	/**
	 * @param userID Function Parameter
	 * @param reservationID Function Parameter
	 * @return boolean
	 */
	boolean cancelBooking(String userID, String reservationID);
	
	/**
	 * @param reservationID Function Parameter
	 * @return ReservationBean
	 */
	ReservationBean viewBookingDetails(String reservationID);
	
	/**
	 * @param reservationID Function Parameter
	 * @return ReservationBean
	 */
	ReservationBean printBookingDetails(String reservationID);
	
	

	String forgotPassword(String userid, String ans);

	
	

}
