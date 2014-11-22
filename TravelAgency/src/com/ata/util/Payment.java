package com.ata.util;

import com.ata.bean.CreditCardBean;
import com.ata.dao.CreditCardDAOImpl;

/**
 * This class is used for processing the transaction of user.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class Payment 
{
	/**
	 * @param userID Function Parameter
	 * @param cardNumber Function Parameter
	 * @return boolean
	 */
	public boolean findByCardNumber(String userID, String cardNumber)
	{
		CreditCardDAOImpl cardDAOImpl=new CreditCardDAOImpl();
		boolean result=false;
		try
		{
			if((userID!=null)&&(cardNumber!=null))
			{

				result=cardDAOImpl.findByCardNumber(userID, cardNumber);
			}
			else
			{
				result=false;
			}
		}
		catch(Exception e)
		{
			result=false;
			e.getMessage();
		}					
		return result;
	}
	
	
	/**
	 * @param creditCardBean Function Parameter
	 * @return String
	 */
	public String process(CreditCardBean creditCardBean)
	{
		
		String result="FAIL";
		CreditCardDAOImpl creditCardDAOImpl= new CreditCardDAOImpl();		
		try
		{
			if(creditCardBean!=null)
			{
				result=creditCardDAOImpl.process(creditCardBean);
			}
			else
			{
				result="FAIL";
			}
		}
		catch(Exception e)
		{
			result="ERROR";
			e.getMessage();
			
		}	
		return result;		
	}	
}
