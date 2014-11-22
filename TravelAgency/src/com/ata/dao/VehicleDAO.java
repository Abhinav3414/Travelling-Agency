package com.ata.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.VehicleBean;

/**
 * This interface is used to define create, delete, find and update Vehicle details
 * @version 1.0
 * @author Abhinav , Abhilash
 */
public interface VehicleDAO 
{
		/**
		 * @param vehicleBean Function Parameter
		 * @return String
		 * @throws SQLException Throws any SQL Exception
		 */
		String createVehicle(VehicleBean vehicleBean) throws SQLException;
	
		/**
		 * @return ArrayList
		 * @throws SQLException Throws any SQL Exception
		 */
		ArrayList<VehicleBean> findAll() throws SQLException;
		
		/**
		 * @param vehicleID Function Parameter
		 * @return int
		 * @throws SQLException Throws any SQL Exception
		 */
		int deleteVehicle(ArrayList<String> vehicleID) throws SQLException;
	
		/**
		 * @param vbean Function Parameter
		 * @return boolean
		 * @throws SQLException Throws any SQL Exception
		 */
		boolean updateVehicle(VehicleBean vbean) throws SQLException;
		
		/**
		 * @param vehicleId Function Parameter
		 * @return VehicleBean 
		 * @throws SQLException Throws any SQL Exception
		 */
		VehicleBean findByID(String vehicleId) throws SQLException;
}
