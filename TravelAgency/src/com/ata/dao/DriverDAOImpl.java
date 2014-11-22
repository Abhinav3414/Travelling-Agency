package com.ata.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.ata.bean.DriverBean;
import com.ata.util.DBUtil;

/**
 * This class is used to declare create, delete, find and update methods for driver details
 * @version 1.0
 * @author Abhinav , Abhilash
 */


public class DriverDAOImpl implements DriverDAO
{
	
	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.DriverDAO#createDriver(com.wipro.ata.bean.DriverBean)
	 */
	@Override
	public String createDriver(DriverBean driverBean) throws SQLException
	{
		int index=0;
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		int i=0;

		String result="FAIL";
		String sqlQuery="Insert into ATA_TBL_driver values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement dbStatement=null;
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		String driverId= generateId(driverBean.getName());

		dbStatement.setString(++index, driverId);
		dbStatement.setString(++index, driverBean.getName());
		dbStatement.setString(++index, driverBean.getStreet());
		dbStatement.setString(++index, driverBean.getLocation());
		dbStatement.setString(++index, driverBean.getCity());
		dbStatement.setString(++index, driverBean.getState());
		dbStatement.setString(++index, driverBean.getPincode());
		dbStatement.setString(++index, driverBean.getMobileNo());
		dbStatement.setString(++index, driverBean.getLicenseNumber());
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
	 * @see com.wipro.ata.dao.DriverDAO#findAll()
	 */
	@Override
	public ArrayList<DriverBean> findAll() throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		ResultSet dbResult=null;
		PreparedStatement dbStatement=null;
		ArrayList<DriverBean> alDriver = new ArrayList<DriverBean>();
		String sqlQuery="select * from ATA_TBL_driver order by name";
		
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbResult=dbStatement.executeQuery();
		int index=0;
		
		while(dbResult.next())
		{
			DriverBean dbean= new DriverBean();
			dbean.setDriverID(dbResult.getString(++index));				
			dbean.setName(dbResult.getString(++index));
			dbean.setStreet(dbResult.getString(++index));
			dbean.setLocation(dbResult.getString(++index));
			dbean.setCity(dbResult.getString(++index));
			dbean.setState(dbResult.getString(++index));
			dbean.setPincode(dbResult.getString(++index));
			dbean.setMobileNo(dbResult.getString(++index));				
			dbean.setLicenseNumber(dbResult.getString(++index));
			alDriver.add(dbean);
			index=0;
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return alDriver;
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.DriverDAO#findByID(java.lang.String)
	 */
	@Override
	public DriverBean findByID(String driverId) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	

		PreparedStatement dbStatement=null;
		ResultSet dbResult=null;
		String sqlQuery="select * from ATA_TBL_driver where driverid=?";
		DriverBean dbean = new DriverBean();
		int index=0;
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(++index, driverId);
		dbResult=dbStatement.executeQuery();
		index=0;
		while(dbResult.next())
		{				
			dbean.setDriverID(dbResult.getString(++index));				
			dbean.setName(dbResult.getString(++index));
			dbean.setStreet(dbResult.getString(++index));
			dbean.setLocation(dbResult.getString(++index));
			dbean.setCity(dbResult.getString(++index));
			dbean.setState(dbResult.getString(++index));
			dbean.setPincode(dbResult.getString(++index));
			dbean.setMobileNo(dbResult.getString(++index));				
			dbean.setLicenseNumber(dbResult.getString(++index));	
			index=0;

		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return dbean;
	}



	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.DriverDAO#updateDriver(com.wipro.ata.bean.DriverBean)
	 */
	@Override

	public boolean updateDriver(DriverBean dbean) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		String sqlQuery="Update ATA_TBL_driver set name=?, street=?, location=?, city=?,state=?, pincode=?,mobileno=?, licensenumber=? where driverid=? ";
		boolean status=false;
		int i=0;
		int index=0;
		PreparedStatement dbStatement=null;

		dbStatement=dbConnection.prepareStatement(sqlQuery);

		dbStatement.setString(++index, dbean.getName());
		dbStatement.setString(++index, dbean.getStreet());
		dbStatement.setString(++index, dbean.getLocation());
		dbStatement.setString(++index, dbean.getCity());
		dbStatement.setString(++index, dbean.getState());
		dbStatement.setString(++index, dbean.getPincode());
		dbStatement.setString(++index, dbean.getMobileNo());
		dbStatement.setString(++index, dbean.getLicenseNumber());
		dbStatement.setString(++index, dbean.getDriverID());

		i=dbStatement.executeUpdate();
		if(i>=1)
		{
			status = true;
		}
		else
		{
			status=false;
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return status;
	}

	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.DriverDAO#deleteDriver(java.util.ArrayList)
	 */
	@Override

	public int deleteDriver(ArrayList<String> driverID) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
		String sqlQuery="delete from ATA_TBL_driver where driverid =?";
		int status=0;
		int deleteStatus=0;
		
		String driverId="";
		
		Iterator<String> itr=driverID.iterator();
		while(itr.hasNext())
		{
			driverId=(String) itr.next(); 
		}
		int index=0;

		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(++index, driverId);
		status=dbStatement.executeUpdate();
		if (status>=1)
		{
			deleteStatus=1;
		}
		else
		{
			deleteStatus=0;
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return deleteStatus;
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
		int index1=0;
		int index2=0;;
		String sqlQuery="values(next value for ata_seq_driverId)";
		try 
		{
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			ResultSet resultSet=dbStatement.executeQuery();
			int index=0;
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
}
