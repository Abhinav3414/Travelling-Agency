package com.ata.bean;

/**
 * This class is used to declare two type of methods for ATA_TBL_driver table : Get and Set
 * The Get methods are used to retrieve the values.
 * The Set methods are used to set the values.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class DriverBean {


	private String driverID;
	private String name;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String licenseNumber;
	
	/**
	 * @return driverID
	 */
	public String getDriverID() 
	{
		return driverID;
	}

	/**
	 * @param driverID Sets DriverID
	 */
	public void setDriverID(String driverID) 
	{
		this.driverID = driverID;
	}

	/**
	 * @return name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param name Sets Name
	 */
	public void setName(String name) 
	{
		this.name = name;
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
	 * @param pincode Sets Pincode
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
	 * @return licenseNumber
	 */
	public String getLicenseNumber() 
	{
		return licenseNumber;
	}
	
	/**
	 * @param licenseNumber Sets License Number
	 */
	public void setLicenseNumber(String licenseNumber)
	{
		this.licenseNumber = licenseNumber;
	}


}
