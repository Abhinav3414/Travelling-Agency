package com.ata.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.ata.bean.ReservationBean;

/**
 * This interface is used to define create,find, update and cancel Reservation details
 * @version 1.0
 * @author Abhinav , Abhilash
 */
public interface ReservationDAO 
{
		/**
		 * @param reservationBean Function Parameter
		 * @return String
		 * @throws SQLException Throws any SQL Exception
		 */
		String createReservation(ReservationBean reservationBean)  throws SQLException;
		
		/**
		 * @param reservationId Function Parameter
		 * @return ReservationBean
		 * @throws SQLException Throws any SQL Exception
		 */
		ReservationBean findByID(String reservationId) throws SQLException;
		
		/**
		 * @return ArrayList
		 * @throws SQLException Throws any SQL Exception
		 */
		ArrayList<ReservationBean> findAllPending() throws SQLException;
		
		/**
		 * @param resbean Function Parameter
		 * @return boolean
		 * @throws SQLException Throws any SQL Exception
		 */
		boolean updateReservation(ReservationBean resbean) throws SQLException;
		
		/**
		 * @param userID Function Parameter
		 * @param reservationID Function Parameter
		 * @return boolean
		 * @throws SQLException Throws any SQL Exception
		 */
		boolean cancelBooking(String userID, String reservationID) throws SQLException;
		
		/**
		 * @param journeyDate Function Parameter
		 * @param source Function Parameter
		 * @param destination Function Parameter
		 * @return ArrayList
		 * @throws SQLException Throws any SQL Exception
		 */
		ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination) throws SQLException;

}
