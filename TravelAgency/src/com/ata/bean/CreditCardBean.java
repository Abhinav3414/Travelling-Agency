package com.ata.bean;

/**
 * This class is used to declare two type of methods for ATA_TBL_CREDITCARD table : Get and Set
 * The Get methods are used to retrieve the values.
 * The Set methods are used to set the values.
 * @author Abhinav , Abhilash
 * @version 1.0
 */

public class CreditCardBean
{
	private String creditcardnumber;
	private String validfrom;
	private String validto;
	private double creditbalance;
	private String userid;
	
	/**
	 * @return creditcardnumber
	 */
	public String getCreditcardnumber()
	{
		return creditcardnumber;
	}
	
	/**
	 * @param creditcardnumber Sets creditCard Number
	 */
	public void setCreditcardnumber(String creditcardnumber) 
	{
		this.creditcardnumber = creditcardnumber;
	}
	
	/**
	 * @return validfrom
	 */
	public String getValidfrom() 
	{
		return validfrom;
	}
	
	/**
	 * @param validfrom Sets valid from Date
	 */
	public void setValidfrom(String validfrom) 
	{
		this.validfrom = validfrom;
	}
	
	/**
	 * @return validto
	 */
	public String getValidto() 
	{
		return validto;
	}
	
	/**
	 * @param validto Sets Validto Date
	 */
	public void setValidto(String validto) 
	{
		this.validto = validto;
	}
	
	/**
	 * @return creditbalance
	 */
	public double getCreditbalance() 
	{
		return creditbalance;
	}
	
	/**
	 * @param creditbalance Sets Credit Balance
	 */
	public void setCreditbalance(double creditbalance) 
	{
		this.creditbalance = creditbalance;
	}

	/**
	 * @return userid
	 */
	public String getUserid() 
	{
		return userid;
	}
	
	/**
	 * @param userid Sets UserId
	 */
	public void setUserid(String userid) 
	{
		this.userid = userid;
	}
}
