package com.ata.util;

import java.sql.SQLException;




import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.CredentialDAOImpl;
import com.ata.dao.ProfileDAOImpl;

/**
 * This class is used to define various methods for User
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class UserImpl implements User
{
	@Override
	public String login(CredentialsBean credentialsBean) 
	{
		String aStatus="FAIL";

		// Login Check
		AuthenticationImpl authenticate = new AuthenticationImpl();
		boolean authenticateStatus = authenticate.authenticate(credentialsBean);
		
		if(credentialsBean!=null)	
		{
			if(authenticateStatus==true)
			{
				aStatus=authenticate.authorize(credentialsBean.getUserID());
				authenticate.changeLoginStatus(credentialsBean, 1);
			}
			else
			{
				aStatus="INVALID";					
			}	
		}
		else
		{
			aStatus="FAIL";
		}
		return aStatus;
	}



	@Override
	public boolean logout(String userId) 
	{		

		CredentialsBean cbean= new CredentialsBean();
		cbean.setUserID(userId);

		AuthenticationImpl authenticate = new AuthenticationImpl();
		boolean status =authenticate.changeLoginStatus(cbean, 0);
		return status;
	}



	@Override

	public String changePassword(CredentialsBean credentialsBean,String newPassword) 
	{

		String status="FAIL";
		CredentialDAOImpl credsDao = new CredentialDAOImpl();

		try {

			if(credentialsBean!=null)
			{
				status=credsDao.changePassword(credentialsBean, newPassword);
			}
			else
			{
				status="FAIL";
			}	
		}
		catch (Exception e) 
		{		
			status="ERROR";
			e.getMessage();

		}
		return status;
	}

	@Override

	public String register(ProfileBean profileBean) 
	{
		String status="FAIL";
		ProfileDAOImpl pDao = new ProfileDAOImpl();
		try {

			if(profileBean!=null)
			{
				status=pDao.register(profileBean);
			}
			else
			{
				status="FAIL";
			}	
		}
		catch (SQLException e) 
		{
			status="ERROR";
			e.getMessage();

		} 
		catch (Exception e) 
		{		
			status="ERROR";
			e.getMessage();

		}
		return status;		
	}



}
