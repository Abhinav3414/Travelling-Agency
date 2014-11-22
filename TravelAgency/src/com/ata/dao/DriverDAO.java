package com.ata.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.DriverBean;

/**
 * This interface is used to define create, delete, find and update driver details
 * @version 1.0
 * @author Abhinav , Abhilash
 */
public interface DriverDAO 
{
 
	/**
	 * @param driverBean Function Parameter
	 * @return String
	 * @throws SQLException Throws any SQL Exception
	 */
	String createDriver(DriverBean driverBean) throws SQLException;
 
	/**
	 * @return ArrayList
	 * @throws SQLException Throws any SQL Exception
	 */
	ArrayList<DriverBean> findAll() throws SQLException;
	
	/**
	 * @param driverId Function Parameter
	 * @return DriverBean
	 * @throws SQLException Throws any SQL Exception
	 */
	DriverBean findByID(String driverId) throws SQLException;
	
	/**
	 * @param dbean Function Parameter
	 * @return boolean
	 * @throws SQLException Throws any SQL Exception
	 */
	boolean updateDriver(DriverBean dbean) throws SQLException;
	
	/**
	 * @param driverID Function Parameter
	 * @return int
	 * @throws SQLException Throws any SQL Exception
	 */
	int  deleteDriver(ArrayList<String> driverID)  throws SQLException;
	

}
