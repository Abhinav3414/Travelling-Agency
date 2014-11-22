
package com.ata.bean;

/**
 * This class is used to declare two type of methods for ATA_TBL_USER_credentials table : Get and Set
 * The Get methods are used to retrieve the values.
 * The Set methods are used to set the values.
 * @version 1.0
 * @author Abhinav Gupta
 * @author Abhilash Rastogi
 */

public class CredentialsBean {
	public String getQus() {
		return qus;
	}

	public void setQus(String qus) {
		this.qus = qus;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	private String userID;
	private String password;
	private String userType;
	private int loginStatus;
	private String qus;
	private String ans;

	
	/**
	 * @return userID
	 */
	public String getUserID() 
	{
		return userID;
	}
	
	/**
	 * @param userID Sets user ID.
	 */
	public void setUserID(String userID) 
	{
		this.userID = userID;
	}
	
	/**
	 * @return password
	 */
	public String getPassword() 
	{
		return password;
	}
	
	/**
	 * @param password Sets Password
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	/**
	 * @return userType
	 */
	public String getUserType() 
	{
		return userType;
	}
	
	/**
	 * @param userType Sets userType
	 */
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}
	
	/**
	 * @return loginStatus
	 */
	public int getLoginStatus() 
	{
		return loginStatus;
	}
	
	/**
	 * @param loginStatus Sets loginStatus
	 */
	public void setLoginStatus(int loginStatus) 
	{
		this.loginStatus = loginStatus;
	}
}
