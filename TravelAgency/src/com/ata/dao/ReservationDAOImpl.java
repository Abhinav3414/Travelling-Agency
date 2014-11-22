package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;
import java.util.Date;

import com.ata.bean.ReservationBean;
import com.ata.util.DBUtil;

/**
 * This class is used to declare create, cancel, find and update methods for Reservation.
 * @version 1.0
 * @author Abhinav , Abhilash
 */


public class ReservationDAOImpl implements ReservationDAO
{
	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.ReservationDAO#createReservation(com.wipro.ata.bean.ReservationBean)
	 */
	@Override
	public String createReservation(ReservationBean reservationBean) throws SQLException
	{

		String result="FAIL";
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);		
		PreparedStatement dbStatement=null;
		String sqlQuery="Insert into ATA_TBL_RESERVATION values(?,?,?,?,?,?,?,?,?,?,?)";
		int index=0;

		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(++index, reservationBean.getReservationID());
		dbStatement.setString(++index, reservationBean.getUserID());
		dbStatement.setString(++index, reservationBean.getVehicleID());
		dbStatement.setString(++index, reservationBean.getRouteID());

		java.sql.Date bookDate= new java.sql.Date(reservationBean.getBookingDate().getTime());
		java.sql.Date journeyDate= new java.sql.Date(reservationBean.getJourneyDate().getTime());

		dbStatement.setDate(++index, bookDate);
		dbStatement.setDate(++index, journeyDate);
		dbStatement.setString(++index, reservationBean.getDriverID());
		dbStatement.setString(++index, reservationBean.getBookingStatus());
		dbStatement.setDouble(++index, reservationBean.getTotalFare());
		dbStatement.setString(++index, reservationBean.getBoardingPoint());
		dbStatement.setString(++index, reservationBean.getDropPoint());
		int i=dbStatement.executeUpdate();
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
	 * @see com.wipro.ata.dao.ReservationDAO#findByID(java.lang.String)
	 */
	@Override
	public ReservationBean findByID(String reservationId) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
		ResultSet dbResult=null;
		ReservationBean resBean = new ReservationBean();
		boolean status=false;
		String sqlQuery="select * from ATA_TBL_reservation where reservationid=?";
		int index=0;
		
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbStatement.setString(++index, reservationId);
		dbResult=dbStatement.executeQuery();
		index=0;
		while(dbResult.next())
		{				
			resBean.setReservationID(dbResult.getString(++index));			
			resBean.setUserID(dbResult.getString(++index));
			resBean.setVehicleID(dbResult.getString(++index));
			resBean.setRouteID(dbResult.getString(++index));
			resBean.setBookingDate(dbResult.getDate(++index));
			resBean.setJourneyDate(dbResult.getDate(++index));
			resBean.setDriverID(dbResult.getString(++index));
			resBean.setBookingStatus(dbResult.getString(++index));				
			resBean.setTotalFare(dbResult.getDouble(++index));	
			resBean.setBoardingPoint(dbResult.getString(++index));	
			resBean.setDropPoint(dbResult.getString(++index));	
			index=0;
			status=true;
		}
		if(status==false)
		{
			resBean=null;
		}
		
		if(dbConnection!=null)
		{
			dbConnection.close();
		}

		return resBean;
	}

	
	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.ReservationDAO#findAllPending()
	 */
	@Override
	public ArrayList<ReservationBean> findAllPending() throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		ResultSet dbResult=null;
		PreparedStatement dbStatement=null;
		ArrayList<ReservationBean> alRes = new ArrayList<ReservationBean>();
		String sqlQuery="select * from ATA_TBL_reservation where bookingstatus='pending'";
		int index=0;

		dbStatement=dbConnection.prepareStatement(sqlQuery);
		dbResult=dbStatement.executeQuery();
		ReservationBean resBean=null;

		while(dbResult.next())
		{
			resBean= new ReservationBean();
			resBean.setReservationID(dbResult.getString(++index));				
			resBean.setUserID(dbResult.getString(++index));
			resBean.setVehicleID(dbResult.getString(++index));
			resBean.setRouteID(dbResult.getString(++index));
			resBean.setBookingDate(dbResult.getDate(++index));
			resBean.setJourneyDate(dbResult.getDate(++index));				
			resBean.setDriverID(dbResult.getString(++index));
			resBean.setBookingStatus(dbResult.getString(++index));
			resBean.setTotalFare(dbResult.getDouble(++index));
			resBean.setBoardingPoint(dbResult.getString(++index));
			resBean.setDropPoint(dbResult.getString(++index));
			alRes.add(resBean);
			index=0;
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}

		return alRes;
	}

	/* (non-Javadoc)
	 * @see com.wipro.ata.dao.ReservationDAO#updateReservation(com.wipro.ata.bean.ReservationBean)
	 */
	@Override
	public boolean updateReservation(ReservationBean resbean) throws SQLException
	{

		boolean status=false;
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
		int index=0;
		int i=0;
		String sqlQuery="update ATA_TBL_RESERVATION set bookingstatus=? , driverid=? where reservationid=?";

		dbStatement=dbConnection.prepareStatement(sqlQuery);

		dbStatement.setString(++index, resbean.getBookingStatus());
		dbStatement.setString(++index, resbean.getDriverID());
		dbStatement.setString(++index, resbean.getReservationID());

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
	 * @see com.wipro.ata.dao.ReservationDAO#cancelBooking(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean cancelBooking(String userID, String reservationID) throws SQLException
	{

		boolean status=false;
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		
		PreparedStatement dbStatement=null;
		PreparedStatement dbStatement1=null;
		PreparedStatement dbStatement2=null;
		PreparedStatement dbStatement3=null;
		String sqlQuery="update ATA_TBL_RESERVATION set bookingstatus=? , driverid=? where reservationid=? and userid=?";
		String query="select creditbalance from ATA_TBL_CREDITCARD where userid=? ";
		String query1="select totalfare from ATA_TBL_RESERVATION where userid=? ";
		String sqlQuery1="update ATA_TBL_CREDITCARD set creditbalance=? where userid=?";
		int index=0;
		int i=0;
		int j=0;
		int creditbalance=0;
	    int fare=0;
	    int amount=0;
		dbStatement=dbConnection.prepareStatement(sqlQuery);
		
		
		dbStatement.setString(++index, "Cancelled");
		dbStatement.setString(++index, "Du1006");
		dbStatement.setString(++index, reservationID);
		dbStatement.setString(++index, userID);
		i=dbStatement.executeUpdate();
		dbStatement2=dbConnection.prepareStatement(query);
		dbStatement2.setString(1,userID);
		ResultSet rs=dbStatement2.executeQuery();
		while(rs.next())
		{
			creditbalance=rs.getInt(1);
			
		}
		dbStatement3=dbConnection.prepareStatement(query1);
		dbStatement3.setString(1,userID);
		ResultSet rs1=dbStatement3.executeQuery();
		
		
		while(rs1.next())
		{
			fare=rs1.getInt(1);
			
		}
		amount=creditbalance+fare;
	
		dbStatement1=dbConnection.prepareStatement(sqlQuery1);
		dbStatement1.setInt(1,amount);
		dbStatement1.setString(2, userID);
		j=dbStatement1.executeUpdate();
	    if(i>=1 && j>=1)
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
	 * @param reservationID Function Parameter
	 * @param driverID Function Parameter
	 * @return boolean
	 * @throws SQLException Throws any SQL Exception
	 */
	public boolean allotDriver(String reservationID, String driverID) throws SQLException
	{

		boolean status=false;
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
		String sqlQuery="update ATA_TBL_RESERVATION set bookingstatus=? , driverid=? where reservationid=?";
		int index=0;
		int i=0;
		dbStatement=dbConnection.prepareStatement(sqlQuery);

		dbStatement.setString(++index, "Approved");
		dbStatement.setString(++index, driverID);
		dbStatement.setString(++index, reservationID);

		i=dbStatement.executeUpdate();
		if(i==1)
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
	 * @param userID Function Parameter
	 * @param reservationID Function Parameter
	 * @return boolean
	 * @throws SQLException Throws any SQL Exception
	 */
	public boolean changeBookingStatus(String userID, String reservationID) throws SQLException
	{

		boolean status=false;
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		PreparedStatement dbStatement=null;
		int index=0;
		int i=0;;
		String sqlQuery="update ATA_TBL_RESERVATION set bookingstatus=? , driverid=? where reservationid=? and userid=?";

		dbStatement=dbConnection.prepareStatement(sqlQuery);

		dbStatement.setString(++index, "pending");
		dbStatement.setString(++index, "Du1006");
		dbStatement.setString(++index, reservationID);
		dbStatement.setString(++index, userID);

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



	/**
	 * @param userId Function Parameter
	 * @return ArrayList
	 * @throws SQLException Throws any SQL Exception
	 */
	public ArrayList<ReservationBean> findAllByID(String userId) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		ResultSet dbResult=null;
		PreparedStatement dbStatement=null;
		int index=0;
		String sqlQuery="select * from ATA_TBL_reservation where userid=?";
		ArrayList<ReservationBean> alRes = new ArrayList<ReservationBean>();

		dbStatement=dbConnection.prepareStatement(sqlQuery);

		dbStatement.setString(++index, userId);
		dbResult=dbStatement.executeQuery();
		index=0;
		ReservationBean resBean=null;
		while(dbResult.next())
		{
			resBean = new ReservationBean();
			resBean.setReservationID(dbResult.getString(++index));				
			resBean.setUserID(dbResult.getString(++index));
			resBean.setVehicleID(dbResult.getString(++index));
			resBean.setRouteID(dbResult.getString(++index));
			resBean.setBookingDate(dbResult.getDate(++index));
			resBean.setJourneyDate(dbResult.getDate(++index));				
			resBean.setDriverID(dbResult.getString(++index));
			resBean.setBookingStatus(dbResult.getString(++index));
			resBean.setTotalFare(dbResult.getDouble(++index));
			resBean.setBoardingPoint(dbResult.getString(++index));
			resBean.setDropPoint(dbResult.getString(++index));
			alRes.add(resBean);
			index=0;
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return alRes;
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
		String sqlQuery="values(next value for ata_seq_reservationId)";
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
				index=0;
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
	 * @param vehicleId Function Parameter
	 * @param routeId Function Parameter
	 * @return double
	 */
	public double calculateTravelFare (String vehicleId, String routeId)
	{
		double totalFare=0;		

		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		ResultSet dbFare=null;
		ResultSet dbDistance=null;
		int index=0;
		String sqlQuery="select fareperkm from ATA_TBL_vehicle where vehicleid=?";
		String sqlQuery2="select distance from ATA_TBL_route where routeid=?";

		PreparedStatement dbStatement=null;
		PreparedStatement  dbStatement2=null;
		double dFare=0;
		double dDistance=0;	
		try 
		{			
			dbStatement=dbConnection.prepareStatement(sqlQuery);
			dbStatement.setString(++index, vehicleId);			
			dbFare =dbStatement.executeQuery();
		
			index=0;
			while(dbFare.next())
			{
				dFare= dbFare.getDouble(++index);	
				index=0;
			}
			 index=0;
			dbStatement2=dbConnection.prepareStatement(sqlQuery2);
			dbStatement2.setString(++index, routeId);			
			
			 index=0;
			dbDistance =dbStatement2.executeQuery();
			while(dbDistance.next())
			{
				dDistance = dbDistance.getDouble(++index);	
				index=0;
			}			
			totalFare=dFare*dDistance;
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
		return totalFare;
	}

	/**
	 * @param journeydate Function Parameter
	 * @return ArrayList
	 */
	public  ArrayList<String> driverAvailable(Date journeydate)
	{

		 
		ArrayList<String> driverList = new ArrayList<String>();
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		ResultSet dbResult=null;
		PreparedStatement dbStatement=null;
		int index=0;
		
		String sqlQuery="select driverid from ATA_TBL_reservation where bookingstatus='approved' and journeydate=?";
		
		java.sql.Date jDate= new java.sql.Date(journeydate.getTime());
		try 
		{
			dbStatement=dbConnection.prepareStatement(sqlQuery);

			dbStatement.setDate(++index, jDate);
			dbResult=dbStatement.executeQuery();

			index=0;
			while(dbResult.next())
			{
				String driverid=dbResult.getString(++index);
				driverList.add(driverid);
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
		return driverList;
	}
	
	
	/**
	 * @param journeyDate Function Parameter
	 * @param source Function Parameter
	 * @param destination Function Parameter
	 * @return ArrayList
	 * @throws SQLException Throws any SQL Exception
	 */
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination) throws SQLException
	{
		Connection dbConnection=null;
		String driverType="org.apache.derby.jdbc.ClientDriver";	
		dbConnection=DBUtil.getDBConnection(driverType);	
		ResultSet dbResult=null;
		PreparedStatement dbStatement=null;
		ArrayList<ReservationBean> alRes = new ArrayList<ReservationBean>();
		boolean status=false;
		String sqlQuery="select * from ATA_TBL_reservation where journeydate=? and boardingpoint=? and droppoint=?";
		
		Date d =  journeyDate;
		java.sql.Date jdate= new java.sql.Date(d.getTime());
		int index=0;

		dbStatement=dbConnection.prepareStatement(sqlQuery);

		dbStatement.setDate(++index, jdate);
		dbStatement.setString(++index, source);
		dbStatement.setString(++index, destination);
		dbResult=dbStatement.executeQuery();
		ReservationBean resBean=null;
		index=0;
		while(dbResult.next())
		{

			resBean= new ReservationBean();
			resBean.setReservationID(dbResult.getString(++index));				
			resBean.setUserID(dbResult.getString(++index));
			resBean.setVehicleID(dbResult.getString(++index));
			resBean.setRouteID(dbResult.getString(++index));
			resBean.setBookingDate(dbResult.getDate(++index));
			resBean.setJourneyDate(dbResult.getDate(++index));				
			resBean.setDriverID(dbResult.getString(++index));
			resBean.setBookingStatus(dbResult.getString(++index));
			resBean.setTotalFare(dbResult.getDouble(++index));
			resBean.setBoardingPoint(dbResult.getString(++index));
			resBean.setDropPoint(dbResult.getString(++index));
			alRes.add(resBean);
			status=true;
			index=0;
		}
		if(status==false)
		{
			alRes=null;
		}
		if(dbConnection!=null)
		{
			dbConnection.close();
		}
		return alRes;
	}
}

	