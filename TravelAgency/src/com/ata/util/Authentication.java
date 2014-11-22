
package com.ata.util;

import com.ata.bean.CredentialsBean;

/**
 * This interface is used to declare methods for Authentication.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public interface Authentication
{
	/**
	 * @param credentialsBean Function Parameter
	 * @return boolean
	 */
	boolean authenticate(CredentialsBean credentialsBean);
	
	/**
	 * @param userID Function Parameter
	 * @return String
	 */
	String authorize(String userID);
	
	/**
	 * @param credentialsBean Function Parameter
	 * @param loginStatus Function Parameter
	 * @return boolean
	 */
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);	
}
