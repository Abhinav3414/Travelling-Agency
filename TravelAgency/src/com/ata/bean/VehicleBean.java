package com.ata.bean;

/**
 * This class is used to declare two type of methods for ATA_TBL_vehicle table : Get and Set
 * The Get methods are used to retrieve the values.
 * The Set methods are used to set the values.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class VehicleBean 
{

	private String vehicleID;
	private String name;
	private String type;
	private String registrationNumber;
	private String seatingCapacity;
	private double	farePerKM;

	/**
	 * @return vehicleID
	 */
	public String getVehicleID() 
	{
		return vehicleID;
	}

	/**
	 * @param vehicleID Sets Vehicle ID
	 */
	public void setVehicleID(String vehicleID) 
	{
		this.vehicleID = vehicleID;
	}
	
	/**
	 * @return name
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * @param name Sets NAME
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return type
	 */
	public String getType() 
	{
		return type;
	}
	
	/**
	 * @param type Sets Type
	 */
	public void setType(String type) 
	{
		this.type = type;
	}

	/**
	 * @return registrationNumber
	 */
	public String getRegistrationNumber() 
	{
		return registrationNumber;
	}
	
	/**
	 * @param registrationNumber Sets Registration Number
	 */
	public void setRegistrationNumber(String registrationNumber) 
	{
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return seatingCapacity
	 */
	public String getSeatingCapacity() 
	{
		return seatingCapacity;
	}

	/**
	 * @param seatingCapacity Sets Seating Capacity
	 */
	public void setSeatingCapacity(String seatingCapacity) 
	{
		this.seatingCapacity = seatingCapacity;
	}
	
	/**
	 * @return farePerKM
	 */
	public double getFarePerKM() 
	{
		return farePerKM;
	}
	
	/**
	 * @param farePerKM Sets FareperKM
	 */
	public void setFarePerKM(double farePerKM) 
	{
		this.farePerKM = farePerKM;
	}


}
