package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ata.bean.ProfileBean;
import com.ata.util.DBUtil;

/**
 * This class is used to declare register and find methods for profile details
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class ProfileDAOImpl implements ProfileDAO {

	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.ProfileDAO#register(com.wipro.ata.bean.ProfileBean)
	 */
	@Override
	public String register(ProfileBean profileBean) throws SQLException
	{
		int index=0;
		int i=0;
		String result="FAIL";
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);		
		PreparedStatement dbStatement=null;	
		String sqlQuery="Insert into ATA_TBL_USER_PROFILE values(?,?,?,?,?,?,?,?,?,?,?,?)";

		dbStatement=dbConnection.prepareStatement(sqlQuery);

		dbStatement.setString(++index, profileBean.getUserID());
		dbStatement.setString(++index, profileBean.getFirstName());
		dbStatement.setString(++index, profileBean.getLastName());

		java.sql.Date dob= new java.sql.Date(profileBean.getDateOfBirth().getTime());

		dbStatement.setDate(++index, dob);
		dbStatement.setString(++index, profileBean.getGender());
		dbStatement.setString(++index, profileBean.getStreet());
		dbStatement.setString(++index, profileBean.getLocation());
		dbStatement.setString(++index, profileBean.getCity());
		dbStatement.setString(++index, profileBean.getState());
		dbStatement.setString(++index, profileBean.getPincode());
		dbStatement.setString(++index, profileBean.getMobileNo());
		dbStatement.setString(++index, profileBean.getEmailID());

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
	

		/* (non-Javadoc)
		 * @see com.wipro.ata.dao.ProfileDAO#findByID(java.lang.String)
		 */
		@Override
		public ProfileBean findByID(String userId) throws SQLException
		{
			Connection dbConnection=null;
			String driverType="org.apache.derby.jdbc.ClientDriver";	
			dbConnection=DBUtil.getDBConnection(driverType);		
			PreparedStatement dbStatement=null;	
			ResultSet dbResult=null;
			ProfileBean profileBean = new ProfileBean();
			String sqlQuery="select * from ATA_TBL_USER_PROFILE where userid=?";

			int index=0;
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, userId);
			dbResult=dbStatement.executeQuery();
			index=0;
			while(dbResult.next())
			{				
				profileBean.setUserID(dbResult.getString(++index));				
				profileBean.setFirstName(dbResult.getString(++index));
				profileBean.setLastName(dbResult.getString(++index));	
				profileBean.setDateOfBirth(dbResult.getDate(++index));
				profileBean.setGender(dbResult.getString(++index));
				profileBean.setStreet(dbResult.getString(++index));
				profileBean.setLocation(dbResult.getString(++index));
				profileBean.setCity(dbResult.getString(++index));				
				profileBean.setState(dbResult.getString(++index));	
				profileBean.setPincode(dbResult.getString(++index));
				profileBean.setMobileNo(dbResult.getString(++index));
				profileBean.setEmailID(dbResult.getString(++index));	
				index=0;
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
			return profileBean;
		}

		
	/**
	 * @param firstName Function Parameter
	 * @return String
	 */
	public String generateId(String firstName) 
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);		
		PreparedStatement dbStatement=null;	
		String seq="z";
		String finalId="z";
		String sqlQuery="values(next value for ata_seq_userId)";
		int index=0;
		int index1=0;
		int index2=0;
		try 
		{		
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			ResultSet resultSet=dbStatement.executeQuery();
				while(resultSet.next())
				{
					int rs=resultSet.getInt(++index);
					Integer rset=rs;
					seq=rset.toString();
				}		
				++index2;
				++index2;
				String id=firstName.substring(index1, index2);
				finalId= id.concat(seq);
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
		return finalId;	
	}
	
	
	
	/**
	 * @param userId Function Parameter
	 * @return String
	 */
	public String registerCredentials( String userId) 
	{
		CredentialDAOImpl cbean= new CredentialDAOImpl();
		String status="FAIL";		
		try {

			if(userId!=null)
			{
				status =cbean.registerCredentials(userId);
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

}
