package com.ata.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.RouteBean;

/**
 * This interface is used to define create, delete, find and update Route details
 * @version 1.0
 * @author Abhinav , Abhilash
 */
public interface RouteDAO 
{
	/**
	 * @param routeBean Function Parameter
	 * @return String
	 * @throws SQLException Throws any SQL Exception
	 */
	String createRoute(RouteBean routeBean) throws SQLException;
	
	/**
	 * @return ArrayList
	 * @throws SQLException Throws any SQL Exception
	 */
	ArrayList<RouteBean> findAll() throws SQLException;
	
	/**
	 * @param routeId Function Parameter
	 * @return RouteBean
	 * @throws SQLException Throws any SQL Exception
	 */
	RouteBean findByID(String routeId) throws SQLException;
	
	/**
	 * @param rbean Function Parameter
	 * @return boolean
	 * @throws SQLException Throws any SQL Exception
	 */
	boolean updateRoute(RouteBean rbean) throws SQLException;
	
	/**
	 * @param routeID Function Parameter
	 * @return int
	 * @throws SQLException Throws any SQL Exception
	 */
	int deleteRoute(ArrayList<String> routeID) throws SQLException;

}
