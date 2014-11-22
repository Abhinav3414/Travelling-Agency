package com.ata.dao;

import java.sql.SQLException;

import com.ata.bean.CreditCardBean;

/**
 * This interface is used to define method for Credit Card function(Payment)
 * @version 1.0
 * @author Abhinav , Abhilash
 */
public interface CreditCardDAO 
{
	 /**
	 * @param creditCardBean Function Parameter
	 * @return String
	 * @throws SQLException Throws any SQL Exception
	 */
	String createCreditCard(CreditCardBean creditCardBean) throws SQLException;
}
