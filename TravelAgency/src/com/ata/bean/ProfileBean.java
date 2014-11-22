package com.ata.bean;

import java.util.Date;

/**
 * This class is used to declare two type of methods for ATA_TBL_USER_PROFILE table : Get and Set
 * The Get methods are used to retrieve the values.
 * The Set methods are used to set the values.
 * @author Abhinav , Abhilash
 * @version 1.0
 */

public class ProfileBean 
{
	private String userID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String emailID;


	/**
	 * @return userID
	 */
	public String getUserID() 
	{
		return userID;
	}
	
	/**
	 * @param userID Sets UserID
	 */
	public void setUserID(String userID) 
	{
		this.userID = userID;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * @param firstName Sets First Name
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	/**
	 * @return lastName
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * @param lastName Sets Last Name
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	/**
	 * @return dateOfBirth
	 */
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	/**
	 * @param dateOfBirth Sets Date of Birth
	 */
	public void setDateOfBirth(Date dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return gender
	 */
	public String getGender() 
	{
		return gender;
	}
	
	/**
	 * @param gender Sets Gender
	 */
	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	/**
	 * @return street
	 */
	public String getStreet() 
	{
		return street;
	}

	/**
	 * @param street Sets Street
	 */
	public void setStreet(String street)
	{
		this.street = street;
	}

	/**
	 * @return location
	 */
	public String getLocation()
	{
		return location;
	}
	
	/**
	 * @param location Sets Location
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}

	/**
	 * @return city
	 */
	public String getCity() 
	{
		return city;
	}

	/**
	 * @param city Sets City
	 */
	public void setCity(String city) 
	{
		this.city = city;
	}

	/**
	 * @return state
	 */
	public String getState() 
	{
		return state;
	}

	/**
	 * @param state Sets State
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	
	/**
	 * @return pincode
	 */
	public String getPincode() 
	{
		return pincode;
	}
	
	/**
	 * @param pincode Sets PinCode
	 */
	public void setPincode(String pincode)
	{
		this.pincode = pincode;
	}
	
	/**
	 * @return mobileNo
	 */
	public String getMobileNo()
	{
		return mobileNo;
	}
	
	/**
	 * @param mobileNo Sets Mobile Number
	 */
	public void setMobileNo(String mobileNo) 
	{
		this.mobileNo = mobileNo;
	}
	
	/**
	 * @return emailID
	 */
	public String getEmailID() 
	{
		return emailID;
	}
	
	/**
	 * @param emailID Sets Email ID
	 */
	public void setEmailID(String emailID) 
	{
		this.emailID = emailID;
	}
}