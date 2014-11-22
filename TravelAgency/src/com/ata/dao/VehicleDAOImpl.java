package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.ata.bean.VehicleBean;
import com.ata.util.DBUtil;

/**
 * This class is used to declare create, delete, find and update methods for Vehicle.
 * @version 1.0
 * @author Abhinav , Abhilash
 */


public class VehicleDAOImpl implements VehicleDAO 
{ 
	
	
	@Override
	public String createVehicle(VehicleBean vehicleBean)  throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);	
		
		String result="FAIL";
		String sqlQuery="Insert into ATA_TBL_vehicle values(?,?,?,?,?,?)";
		int i=0;
		int index=0;
		
		PreparedStatement dbStatement=null;
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			
			String vehicleId= generateId(vehicleBean.getName());		
			vehicleBean.setVehicleID(vehicleId);
					
			dbStatement.setString(++index, vehicleBean.getVehicleID());
			dbStatement.setString(++index, vehicleBean.getName());
			dbStatement.setString(++index, vehicleBean.getType());
			dbStatement.setString(++index, vehicleBean.getRegistrationNumber());
			dbStatement.setString(++index, vehicleBean.getSeatingCapacity());
			dbStatement.setDouble(++index, vehicleBean.getFarePerKM());

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

	//----------------------------------------------------------------------------------------
	//View ALL vehilce Details

	@Override
	public ArrayList<VehicleBean> findAll() throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);
		
		PreparedStatement dbStatement=null;
		ResultSet dbResult=null;
		int index=0;
		boolean status=false;
		ArrayList<VehicleBean> alVehicle = new ArrayList<VehicleBean>();
		String sqlQuery="select * from ATA_TBL_vehicle order by name";

			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbResult=dbStatement.executeQuery();

			while(dbResult.next())
			{
				VehicleBean vbean = new VehicleBean();
				vbean.setVehicleID(dbResult.getString(++index));				
				vbean.setName(dbResult.getString(++index));
				vbean.setType(dbResult.getString(++index));
				vbean.setRegistrationNumber(dbResult.getString(++index));
				vbean.setSeatingCapacity(dbResult.getString(++index));
				vbean.setFarePerKM(dbResult.getDouble(++index));
				alVehicle.add(vbean);
				status=true;
				index=0;
			}
			if(status==false)
			{
				alVehicle=null;
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
		return alVehicle;
	}


	
	/**
	 * @param orderType Function Parameter
	 * @return ArrayList
	 * @throws SQLException Throws any SQLException
	 */
	public ArrayList<VehicleBean> findAllSorted(String orderType) throws SQLException
	{
		
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);
		boolean status=false;
		PreparedStatement dbStatement=null;
		ResultSet dbResult=null;
		String sqlQuery="select * from ATA_TBL_vehicle where type=?";
		int index=0;
		ArrayList<VehicleBean> alVehicle = new ArrayList<VehicleBean>();

				dbStatement=dbConnection.prepareStatement(sqlQuery);
				dbStatement.setString(++index, orderType);
				dbResult=dbStatement.executeQuery();
			
				index=0;
			while(dbResult.next())
			{
				VehicleBean vbean = new VehicleBean();
				vbean.setVehicleID(dbResult.getString(++index));				
				vbean.setName(dbResult.getString(++index));
				vbean.setType(dbResult.getString(++index));
				vbean.setRegistrationNumber(dbResult.getString(++index));
				vbean.setSeatingCapacity(dbResult.getString(++index));
				vbean.setFarePerKM(dbResult.getDouble(++index));
				index=0;
				alVehicle.add(vbean);
				status=true;
			}
			if(status==false)
			{
				alVehicle=null;
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
		return alVehicle;
	}
	
	
	
	
	
	

	/**
	 * @param noOfSeats Function Parameter
	 * @return ArrayList
	 * @throws SQLException Throws any SQLException
	 */
	public ArrayList<VehicleBean> findAllSortedSeats(int noOfSeats) throws SQLException
	{
		
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);
		
		String sqlQuery="select * from ATA_TBL_vehicle where seatingcapacity=?";
		int index=0;
		boolean status=false;
		PreparedStatement dbStatement=null;
		ResultSet dbResult=null;
		ArrayList<VehicleBean> alVehicle = new ArrayList<VehicleBean>();

		
	
				dbStatement=dbConnection.prepareStatement(sqlQuery);
				dbStatement.setInt(++index, noOfSeats);
				dbResult=dbStatement.executeQuery();
				index=0;
			

			while(dbResult.next())
			{
				VehicleBean vbean = new VehicleBean();
				vbean.setVehicleID(dbResult.getString(++index));				
				vbean.setName(dbResult.getString(++index));
				vbean.setType(dbResult.getString(++index));
				vbean.setRegistrationNumber(dbResult.getString(++index));
				vbean.setSeatingCapacity(dbResult.getString(++index));
				vbean.setFarePerKM(dbResult.getDouble(++index));

				alVehicle.add(vbean);
				status=true;
				index=0;
			}
			if(status==false)
			{
				alVehicle=null;
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
		return alVehicle;
	}

//--------------------------------------------------------------------------
	//find a vehilce by id
	@Override
	public VehicleBean findByID(String vehicleId) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);

		PreparedStatement dbStatement=null;
		ResultSet dbResult=null;
		VehicleBean vbean = new VehicleBean();
		boolean status=false;
		String sqlQuery="select * from ATA_TBL_vehicle where vehicleid=?";
		int index=0;
		
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, vehicleId);
			dbResult=dbStatement.executeQuery();
			index=0;
			
			while(dbResult.next())
			{				
				vbean.setVehicleID(dbResult.getString(++index));				
				vbean.setName(dbResult.getString(++index));
				vbean.setType(dbResult.getString(++index));
				vbean.setRegistrationNumber(dbResult.getString(++index));
				vbean.setSeatingCapacity(dbResult.getString(++index));
				vbean.setFarePerKM(dbResult.getDouble(++index));
				
				status=true;
			}
			if(status==false)
			{
				vbean=null;
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
	
		return vbean;
	}


	// deleting a vehicle
	@Override
	public int deleteVehicle(ArrayList<String> vehicleID) throws SQLException
	
	{

		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);
		String sqlQuery="delete from ATA_TBL_vehicle where vehicleid =?";
		PreparedStatement dbStatement=null;
		int status=0;
		int deleteStatus=0;
		String vehilceId="";
		int index=0;
		
			Iterator<String> itr=vehicleID.iterator();
			while(itr.hasNext())
			{
				vehilceId=(String) itr.next(); 
			}
					
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, vehilceId);
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

	// updating a vehicle

	@Override
	public boolean updateVehicle(VehicleBean vbean) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);
		String sqlQuery="Update ATA_TBL_vehicle set name=?, type=?, registrationnumber=?, seatingcapacity=?,fareperkm=? where vehicleid=? ";
		boolean status=false;
		int index=0;
	
		PreparedStatement dbStatement=null;
			dbStatement=dbConnection.prepareStatement(sqlQuery);

			dbStatement.setString(++index, vbean.getName());
			dbStatement.setString(++index, vbean.getType());
			dbStatement.setString(++index, vbean.getRegistrationNumber());
			dbStatement.setString(++index, vbean.getSeatingCapacity());
			dbStatement.setDouble(++index, vbean.getFarePerKM());
			dbStatement.setString(++index, vbean.getVehicleID());

			int i=dbStatement.executeUpdate();
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
		String sqlQuery="values(next value for ata_seq_driverId)";
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
				String id=firstName.substring(index1,index2);
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
