package com.ata.util;

import java.sql.SQLException;

import com.ata.bean.CredentialsBean;
import com.ata.dao.CredentialDAOImpl;

/**
 * This class is used to define various methods for Authentication
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class AuthenticationImpl implements Authentication
{

	
	@Override
	public boolean authenticate(CredentialsBean credentialsBean) 
	{
		boolean authenticateStatus=false;
		CredentialDAOImpl credsDao = new CredentialDAOImpl();
		try {

			if(credentialsBean!=null)
			{
				authenticateStatus=credsDao.authenticate(credentialsBean);
			}
			else
			{
				authenticateStatus=false;
			}
		} 
		catch (SQLException e) 
		{
			authenticateStatus=false;
			e.getMessage();

		} catch (Exception e) 
		{
			authenticateStatus=false;
			e.getMessage();

		}
		return authenticateStatus;
	}

	
	@Override
	public String authorize(String userID) 
	{	
		boolean status=false;
		String uType="FAIL";
		CredentialDAOImpl credsDao = new CredentialDAOImpl();
		try {
			if(userID!=null)
			{
				uType=credsDao.authorize(userID);
				status=true;
			}		
			if(status==false)
			{
				uType="INVALID";
			}
		} 
		catch (SQLException e) 
		{
			 uType="ERROR";
			 e.getMessage();

		} 
		catch (Exception e) 
		{
			 uType="ERROR";
			 e.getMessage();

		}		
		return uType;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean,int loginStatus) 
	{
		boolean status=false;
		CredentialDAOImpl credsDao = new CredentialDAOImpl();
		try 
		{
			if(credentialsBean!=null)
			{
				status=credsDao.changeLoginStatus(credentialsBean, loginStatus);
			}
			else
			{
				status=false;
			}
		} 
		catch (SQLException e)
		{
			status=false;
			e.getMessage();

		} 
		catch (Exception e) 
		{
			status=false;
			e.getMessage();

		}				
		return status;
	}	
}
