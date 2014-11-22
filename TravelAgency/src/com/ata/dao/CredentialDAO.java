package com.ata.dao;

import java.sql.SQLException;

import com.ata.bean.CredentialsBean;

/**
 * This interface is used to define various methods for Login and Logout
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public interface CredentialDAO 
{
	/**
	 * @param credentialsBean Function Parameter
	 * @return boolean
	 * @throws SQLException Throws any SQL Exception
	 */
	boolean authenticate(CredentialsBean credentialsBean)  throws SQLException;
	
	/**
	 * @param userID Function Parameter
	 * @return String 
	 * @throws SQLException Throws any SQL Exception
	 */
	String authorize(String userID) throws SQLException;
	
	/**
	 * @param credentialsBean Function Parameter
	 * @param loginStatus  Function Parameter
	 * @return boolean
	 * @throws SQLException Throws any SQL Exception
	 */
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) throws SQLException;	
	
	 /**
	 * @param userId Function Parameter
	 * @return CredentialsBean
	 * @throws SQLException Throws any SQL Exception
	 */
	CredentialsBean findByID(String userId) throws SQLException;

	String forgotPassword(String userid, String ans);
}
