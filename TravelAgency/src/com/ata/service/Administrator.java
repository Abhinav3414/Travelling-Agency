package com.ata.service;

import java.util.ArrayList;
import java.util.Date;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

/**
 * This interface is used to declare various methods for Administrator
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public interface Administrator {

	
	/**
	 * @param vehicleBean Function Parameter
	 * @return String
	 */
	String addVehicle(VehicleBean vehicleBean);
	
	/**
	 * @param vehicleID Function Parameter
	 * @return int
	 */
	int deleteVehicle(ArrayList<String> vehicleID);
	
	/**
	 * @param vehicleID Function Parameter
	 * @return VehicleBean
	 */
	VehicleBean viewVehicle(String vehicleID);
	
	/**
	 * @param vehicleBean Function Parameter
	 * @return boolean
	 */
	boolean modifyVehicle(VehicleBean vehicleBean);
	
	
	/**
	 * @param driverBean Function Parameter
	 * @return String
	 */
	String addDriver(DriverBean driverBean);
	
	/**
	 * @param driverID Function Parameter
	 * @return int
	 */
	int deleteDriver(ArrayList<String> driverID);
	
	/**
	 * @param reservationID Function Parameter
	 * @param driverID Function Parameter
	 * @return boolean
	 */
	boolean allotDriver(String reservationID, String driverID);
	
	/**
	 * @param driverBean Function Parameter
	 * @return boolean
	 */
	boolean modifyDriver(DriverBean driverBean);
	
	
	/**
	 * @param routeBean Function Parameter
	 * @return String
	 */
	String addRoute(RouteBean routeBean);
	
	/**
	 * @param routeID Function Parameter
	 * @return int
	 */
	int deleteRoute(ArrayList<String> routeID);
	
	/**
	 * @param routeID Function Parameter
	 * @return RouteBean
	 */
	RouteBean viewRoute(String routeID);
	
	/**
	 * @param routeBean Function Parameter
	 * @return boolean
	 */
	boolean modifyRoute(RouteBean routeBean);
	
	
	
	/**
	 * @param journeyDate Function Parameter
	 * @param source Function Parameter
	 * @param destination Function Parameter
	 * @return ArrayList
	 */
	ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination);
	
	
	
	
	
	
	
	
	
	
	
	
}
