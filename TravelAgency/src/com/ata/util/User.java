package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;

/**
 * This interface is used to declare methods for User.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public interface User 
{
	/**
	 * @param credentialsBean Function Parameter
	 * @return String
	 */
	String login(CredentialsBean credentialsBean);
	
	/**
	 * @param userId Function Parameter
	 * @return boolean
	 */
	boolean logout(String userId);
	
	/**
	 * @param credentialsBean Function Parameter
	 * @param newPassword Function Parameter
	 * @return String
	 */
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	
	/**
	 * @param profileBean Function Parameter
	 * @return String
	 */
	String register(ProfileBean profileBean);
	
}
