package com.ata.dao;

import java.sql.SQLException;

import com.ata.bean.ProfileBean;

/**
 * This interface is used to define register and find profile details
 * @version 1.0
 * @author Abhinav , Abhilash
 */
public interface ProfileDAO {
	
	/**
	 * @param profileBean Function Parameter
	 * @return String
	 * @throws SQLException Throws any SQL Exception
	 */
	String register(ProfileBean profileBean) throws SQLException;
	 
	 /**
	 * @param userId Function Parameter
	 * @return ProfileBean
	 * @throws SQLException Throws any SQL Exception
	 */
	ProfileBean findByID(String userId) throws SQLException;

}
