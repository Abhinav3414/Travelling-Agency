package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






import java.util.Iterator;

import com.ata.bean.RouteBean;
import com.ata.util.DBUtil;

/**
 * This class is used to declare create, delete, find and update methods for Route
 * @version 1.0
 * @author Abhinav , Abhilash
 */


public class RouteDAOImpl implements RouteDAO
{
	

	//create a route
	@Override
	public String createRoute(RouteBean routeBean) throws SQLException
	{
		
		String result="FAIL";
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		String sqlQuery="Insert into ATA_TBL_route values(?,?,?,?,?)";
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
		int i=0;
		int index=0;
		int index1=0;
		int index2=0;
		

		String routeDestinationId=null;
		String routeID=null;

		dbStatement=dbConnection.prepareStatement(sqlQuery);

		routeDestinationId= generateId(routeBean.getDestination());

		++index2;
		++index2;
		String source= routeBean.getSource().substring(index1,index2);
		routeID= source.concat(routeDestinationId);

		dbStatement.setString(++index, routeID);
		dbStatement.setString(++index, routeBean.getSource());
		dbStatement.setString(++index, routeBean.getDestination());
		dbStatement.setDouble(++index, routeBean.getDistance());
		dbStatement.setDouble(++index, routeBean.getTravelDuration());

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
	//View ALL route Details
	@Override
	public ArrayList<RouteBean> findAll() throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);	
		
		ArrayList<RouteBean> alRoute = new ArrayList<RouteBean>();
		PreparedStatement dbStatement=null;
		ResultSet dbResult=null;
		String sqlQuery="select * from ATA_TBL_route";
		int index=0;
		
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbResult=dbStatement.executeQuery();

			while(dbResult.next())
			{
				RouteBean rbean = new RouteBean();
				rbean.setRouteID(dbResult.getString(++index));				
				rbean.setSource(dbResult.getString(++index));
				rbean.setDestination(dbResult.getString(++index));
				rbean.setDistance(dbResult.getDouble(++index));
				rbean.setTravelDuration(dbResult.getDouble(++index));
								index=0;
				alRoute.add(rbean);
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}		
		return alRoute;
	}
	
	//find a route by id
	
	@Override
	public RouteBean findByID(String routeId) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);
		ResultSet dbResult=null;
		boolean status=false;
		String sqlQuery="select * from ATA_TBL_route where routeid=?";
		int index=0;
		
		RouteBean rbean = new RouteBean();
		PreparedStatement dbStatement=null;
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, routeId);
			dbResult=dbStatement.executeQuery();
			
			index=0;
			while(dbResult.next())
			{				
				rbean.setRouteID(dbResult.getString(++index));				
				rbean.setSource(dbResult.getString(++index));
				rbean.setDestination(dbResult.getString(++index));
				rbean.setDistance(dbResult.getDouble(++index));
				rbean.setTravelDuration(dbResult.getDouble(++index));
				status=true;			
			}
			if(status==false)
			{
				rbean=null;
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
		return rbean;
	}

	
	@Override
	public boolean updateRoute(RouteBean rbean) throws SQLException
	{
		boolean status=false;
		Connection dbConnection=null;
		int i=0;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);
		String sqlQuery="Update ATA_TBL_route set source=?, destination=?, distance=?, travelduration=? where routeid=? ";
		int index=0;
		
		PreparedStatement dbStatement=null;
			dbStatement=dbConnection.prepareStatement(sqlQuery);

			dbStatement.setString(++index, rbean.getSource());
			dbStatement.setString(++index, rbean.getDestination());
			dbStatement.setDouble(++index, rbean.getDistance());
			dbStatement.setDouble(++index, rbean.getTravelDuration());
			dbStatement.setString(++index, rbean.getRouteID());			

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
	
	
	@Override
	public int deleteRoute(ArrayList<String> routeID) throws SQLException
	{

		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";		
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
				
		int status=0;
		int deleteStatus=0;
		String routeId="";
		String sqlQuery="delete from ATA_TBL_route where routeid =?";
		int index=0;
		Iterator<String> itr=routeID.iterator();
		while(itr.hasNext())
		{
			routeId=(String) itr.next(); 
		}
		
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, routeId);
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
		String sqlQuery="values(next value for ata_seq_routeId)";
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

}
