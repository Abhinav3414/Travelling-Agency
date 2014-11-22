package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ata.bean.CreditCardBean;
import com.ata.util.DBUtil;

/**
 * This class is used to declare create, process and find methods for Credit Card (Payment)
 * @version 1.0
 * @author Abhinav , Abhilash
 */
public class CreditCardDAOImpl implements CreditCardDAO
{

	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.CreditCardDAO#createCreditCard(com.wipro.ata.bean.CreditCardBean)
	 */
	@Override
	public String createCreditCard(CreditCardBean creditCardBean) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		String result="FAIL";
		String sqlQuery="Insert into ATA_TBL_CREDITCARD values(?,?,?,?,?)";

		PreparedStatement dbStatement=null;

		int index=1;
		int i=0;
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(index, creditCardBean.getCreditcardnumber());
		dbStatement.setString(++index, creditCardBean.getValidfrom());
		dbStatement.setString(++index, creditCardBean.getValidto());
		dbStatement.setDouble(++index, creditCardBean.getCreditbalance());
		dbStatement.setString(++index, creditCardBean.getUserid());
		i=dbStatement.executeUpdate();
		if(i>=1)
		{
			result = "SUCCESS";
		}
		else
		{
			result="FAIL";
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}

		return result;
	}

	/**
	 * @param userID Function Parameter
	 * @param cardNumber Function Parameter
	 * @return boolean
	 * @throws SQLException Throws any Sql Exception
	 */
	public boolean findByCardNumber(String userID, String cardNumber) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		boolean status=false;
		ResultSet dbResult=null;
		String sqlQuery="select * from ATA_TBL_CREDITCARD where creditcardnumber=? and userid=? ";
		int index=1;

		PreparedStatement dbStatement=null;
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(index, cardNumber);
		dbStatement.setString(++index, userID);

		dbResult=dbStatement.executeQuery();
		while(dbResult.next())
		{
			status = true;
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return status;
	}

	/**
	 * @param creditCardBean Function PArameter
	 * @return String
	 * @throws SQLException Throws any Sql Exception
	 */
	public String process(CreditCardBean creditCardBean) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		String result="FAIL";
		ResultSet dbResult=null;
		double balance=0;
		String sqlQuery="select creditbalance from ATA_TBL_CREDITCARD where creditcardnumber=? and userid=? ";
		int j=0;
		int i=0;
		int index=1;
		PreparedStatement dbStatement=null;
		PreparedStatement dbStatement2=null;

		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(index, creditCardBean.getCreditcardnumber());
		dbStatement.setString(++index, creditCardBean.getUserid());

		dbResult=dbStatement.executeQuery();
		index=0;
		while(dbResult.next())
		{
			balance=dbResult.getDouble(++index);
			j=1;
			index=0;
		}
		index=0;
		if(j==1)
		{
			balance=balance-creditCardBean.getCreditbalance();
			creditCardBean.setCreditbalance(balance);
			String sqlQuery2="update ATA_TBL_CREDITCARD set creditbalance=? where creditcardnumber=?";
			
			dbStatement2=dbConnection.prepareStatement(sqlQuery2);
			dbStatement2.setDouble(++index, balance);
			dbStatement2.setString(++index, creditCardBean.getCreditcardnumber());
			i=dbStatement2.executeUpdate();
			if(i>=1)
			{
				result = "SUCCESS";
			}	
		}
		else
		{
			result = "FAIL";
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return result;
	}

}
