package com.ata.bean;

import java.util.Date;

/**
 * This class is used to declare two type of methods for ATA_TBL_RESERVATION table : Get and Set
 * The Get methods are used to retrieve the values.
 * The Set methods are used to set the values.
 * @author Abhinav , Abhilash
 * @version 1.0
 */

public class ReservationBean {

	private String reservationID;
	private String userID;
	private String routeID;
	private Date bookingDate;
	private Date journeyDate;
	private String vehicleID;
	private String driverID;
	private String bookingStatus;
	private double totalFare;
	private String boardingPoint;
	private String dropPoint;

	/**
	 * @return reservationID
	 */
	public String getReservationID()
	{
		return reservationID;
	}
	
	/**
	 * @param reservationID Sets Reservation ID
	 */
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	
	/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * @param userID Sets UserID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * @return routeID
	 */
	public String getRouteID() {
		return routeID;
	}

	/**
	 * @param routeID Sets RouteID
	 */
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	/**
	 * @return bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate Sets booking Date
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	/**
	 * @return journeyDate
	 */
	public Date getJourneyDate() {
		return journeyDate;
	}
	
	/**
	 * @param journeyDate Sets Journey Date
	 */
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	/**
	 * @return vehicleID
	 */
	public String getVehicleID() {
		return vehicleID;
	}
	
	/**
	 * @param vehicleID Sets Vehicle ID
	 */
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	/**
	 * @return driverID
	 */
	public String getDriverID() {
		return driverID;
	}

	/**
	 * @param driverID Sets DriverID
	 */
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	
	/**
	 * @return bookingStatus
	 */
	public String getBookingStatus() {
	return bookingStatus;
	}
	
	/**
	 * @param bookingStatus Sets Booking Status
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	/**
	 * @return totalFare
	 */
	public double getTotalFare() {
		return totalFare;
	}

	/**
	 * @param totalFare Sets Total Fare
	 */
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	
	/**
	 * @return boardingPoint
	 */
	public String getBoardingPoint() {
		return boardingPoint;
	}
	
	/**
	 * @param boardingPoint Sets Boarding Point
	 */
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	
	/**
	 * @return dropPoint
	 */
	public String getDropPoint() {
		return dropPoint;
	}
	
	/**
	 * @param dropPoint Sets Drop pOint
	 */
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	} 

	
}
