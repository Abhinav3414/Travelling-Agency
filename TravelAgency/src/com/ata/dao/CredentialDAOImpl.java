package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ata.bean.CredentialsBean;
import com.ata.util.DBUtil;


/**
 * This class is used to define various methods for Credentials(Login and Logout)
 * @version 1.0
 * @author Abhinav , Abhilash
 */


public class CredentialDAOImpl implements CredentialDAO
{
	
	/* (non-Javadoc)
	 * This method is used to check if the user exists in database.
	 * @see com.wipro.ata.dao.CredentialDAO#authenticate(com.wipro.ata.bean.CredentialsBean)
	 */
	@Override
	public boolean authenticate(CredentialsBean credentialsBean) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;	
		String sqlQuery="select * from ATA_TBL_USER_credentials where userid = ? and password = ?";
		
		boolean authenticateStatus=false;
		ResultSet Status=null;
		int index=0;
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(++index, credentialsBean.getUserID());
		dbStatement.setString(++index, credentialsBean.getPassword());
		Status=dbStatement.executeQuery();
		
		while(Status.next())
		{
			authenticateStatus=true;
		}			

		if(dbConnection!=null)
		{
			dbConnection.close();
		} 	
	return authenticateStatus;
	}


	/* (non-Javadoc)
	 * This method checks if the user is Administrator or Customer
	 * @see com.wipro.ata.dao.CredentialDAO#authorize(java.lang.String)
	 */
	@Override
	public String authorize(String userID)  throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;	
		ResultSet dbResult=null;
		String sqlQuery="select usertype from ATA_TBL_USER_credentials where userid = ?";
		String uType="z";
		int index=0;
		
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, userID);
			dbResult =dbStatement.executeQuery();
			index=0;
			
			while(dbResult.next())
			{
				uType=dbResult.getString(++index);
				index=0;
			}	

			if(dbConnection!=null)
			{
				dbConnection.close();
			} 

			return uType;
	}



	/* (non-Javadoc)
	 * This method is used to change the Login status of the User.
	 * @see com.wipro.ata.dao.CredentialDAO#changeLoginStatus(com.wipro.ata.bean.CredentialsBean, int)
	 */
	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean,int loginStatus)  throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
		String sqlQuery="update ATA_TBL_USER_credentials set loginstatus = ? where userid = ?";
		boolean status=false;
		int index=0;
		int i=0;
			
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setInt(++index, loginStatus);
			dbStatement.setString(++index, credentialsBean.getUserID());		

			i =dbStatement.executeUpdate();
			if(i>=1)
			{
				status=true;
			}			
	
		if(dbConnection!=null)
		{
			dbConnection.close();
		} 	
		return status;
	}

	
	
	
	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.CredentialDAO#findByID(java.lang.String)
	 */
	@Override
	public CredentialsBean findByID(String userId)
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;	
		ResultSet dbResult=null;
		String sqlQuery="select * from ATA_TBL_USER_credentials where userid=?";
		int index=0;
		CredentialsBean cBean = new CredentialsBean();
		try 
		{
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, userId);
			dbResult=dbStatement.executeQuery();
			index=0;
			while(dbResult.next())
			{				
				cBean.setUserID(dbResult.getString(++index));				
				cBean.setPassword(dbResult.getString(++index));
				cBean.setUserType(dbResult.getString(++index));
				cBean.setLoginStatus(dbResult.getInt(++index));
				index=0;
			}
		}
		catch (SQLException e) 
		{	
			e.getMessage();
		}	
		finally
		{
			try 
			{
				dbConnection.close();
			} 
			catch (SQLException e) 
			{
				e.getMessage();
			}
		}
		return cBean;
	}


	/**
	 * This method is used to change the password of User.
	 * @param credentialsBean Function Parameter
	 * @param newPassword  Function Parameter
	 * @return String
	 */
	public String changePassword(CredentialsBean credentialsBean,String newPassword) 
	{
		String result="FAIL";
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;	
		String sqlQuery="update ATA_TBL_USER_credentials set password=? where userid=?";
		int index=1;
		int i=0;
		try 
		{
			dbStatement=dbConnection.prepareStatement(sqlQuery);			
			dbStatement.setString(index, newPassword);
			dbStatement.setString(++index, credentialsBean.getUserID());			
			i=dbStatement.executeUpdate();
			if(i>=1)
			{
				result = "SUCCESS";
			}	
			else
			{
				result="FAIL";
			}
		}
		catch (SQLException e) 
		{
			result = "ERROR";
			e.getMessage();
		}	
		finally
		{
			try 
			{
				dbConnection.close();
			} 
			catch (SQLException e) 
			{
				result = "ERROR";
				e.getMessage();
			}
		}
		return result;
	}

	/**
	 * This method is used to Register new User Credentials.
	 * @param userId  Function Parameter
	 * @return String
	 */
	public String registerCredentials( String userId) 
	{
		String result="FAIL";
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;	
		String sqlQuery="Insert into ATA_TBL_USER_credentials values(?,?,?,?)";
		int index=1;
		int i=0;
		try 
		{
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(index, userId);
			dbStatement.setString(++index, "password123");
			dbStatement.setString(++index, "C");
			dbStatement.setInt(++index, 0);
			i=dbStatement.executeUpdate();
			if(i>=1)
			{
				 result="SUCCESS";
			}	
			else
			{
				result="FAIL";
			}
		}
		catch (SQLException e) 
		{
			 result="ERROR";
			 e.getMessage();
		}	
		finally
		{
			try 
			{
				dbConnection.close();
			} 
			catch (SQLException e) 
			{
				result="ERROR";
				e.getMessage();
			}
		}
		return result;
	}


@Override
public String forgotPassword(String userid, String ans) {
	System.out.println("here");
	String result="";
	Connection dbConnection=null;
	String driverType="org.apache.derby.jdbc.ClientDriver";	
	dbConnection=DBUtil.getDBConnection(driverType);
	System.out.println("connected");
	ResultSet dbResult=null;
	PreparedStatement dbStatement=null;	
	String sqlQuery="select ans from ATA_TBL_USER_credentials where userid=? and ans=?";
	System.out.println("sql");
    
		try {
			System.out.println("inside try");
			System.out.println("userid"+userid);
			System.out.println("ans"+ans);
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(1,userid);
			dbStatement.setString(2,ans);
			
			dbResult =dbStatement.executeQuery(); 
			System.out.println("query executed");
			while(dbResult.next())
			{
				result="SUCCESS";
				System.out.println(result);
			}
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
	return result;
}


public String updatePassword(CredentialsBean credentialsBean, String password) {
	String result="FAIL";
	Connection dbConnection=null;
	String driverType="org.apache.derby.jdbc.ClientDriver";	
	dbConnection=DBUtil.getDBConnection(driverType);	
	PreparedStatement dbStatement=null;	
	String sqlQuery="update ATA_TBL_USER_credentials set password=? where userid=?";
	int i=0;
	try 
	{
		dbStatement=dbConnection.prepareStatement(sqlQuery);			
		dbStatement.setString(1,password );
		dbStatement.setString(2,credentialsBean.getUserID());			
		i=dbStatement.executeUpdate();
		if(i>=1)
		{
			result = "SUCCESS";
		}	
		else
		{
			result="FAIL";
		}
	}
	catch (SQLException e) 
	{
		result = "ERROR";
		e.getMessage();
	}	
	finally
	{
		try 
		{
			dbConnection.close();
		} 
		catch (SQLException e) 
		{
			result = "ERROR";
			e.getMessage();
		}
	}
	return result;
}
}




		