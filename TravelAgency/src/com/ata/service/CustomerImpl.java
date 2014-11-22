package com.ata.service;

import java.util.ArrayList;









import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.CredentialDAO;
import com.ata.dao.CredentialDAOImpl;
import com.ata.dao.ReservationDAOImpl;
import com.ata.dao.RouteDAOImpl;
import com.ata.dao.VehicleDAOImpl;

/**
 * This class is used to define various methods for Customer
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class CustomerImpl implements Customer
{

	/** 
	 * @see com.ata.service.Customer#viewVehiclesByType(java.lang.String)
	 * @param vehicleType Function Parameter
	 * @return ArrayList
	 */
	@Override
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType) 
	{

		ArrayList<VehicleBean> alVehicle = new ArrayList<VehicleBean>();
		try
		{
			if(vehicleType!=null)
			{
				VehicleDAOImpl vehicleDao= new VehicleDAOImpl();
				alVehicle= vehicleDao.findAllSorted(vehicleType);
			}
			else
			{
				alVehicle= null;	
			}
		}
		catch(Exception e)
		{
			alVehicle= null;				
			e.getMessage();
		}
		return alVehicle;
	}

	/** 
	 * @see com.ata.service.Customer#viewVehicleBySeats(int)
	 * @param noOfSeats Function Parameter
	 * @return ArrayList
	 */
	@Override
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) 
	{
		VehicleDAOImpl vehicleDao= new VehicleDAOImpl();
		ArrayList<VehicleBean> alVehicle = new ArrayList<VehicleBean>();
		
		try
		{
			if(noOfSeats!=0)
			{
				alVehicle= vehicleDao.findAllSortedSeats(noOfSeats);
			}
			else
			{
				alVehicle= null;
			}
		}
		catch(Exception e)
		{
			e.getMessage();
			alVehicle= null;
		}
		return alVehicle;
		
	}

	/** 
	 * @see com.ata.service.Customer#viewAllRoutes()
	 * @return ArrayList
	 */
	@Override
	public ArrayList<RouteBean> viewAllRoutes() 
	{

		RouteDAOImpl routeDao= new RouteDAOImpl();
		ArrayList<RouteBean> alRoute = new ArrayList<RouteBean>();
		
		try
		{			
			alRoute= routeDao.findAll();	
		}
		catch(Exception e)
		{
			alRoute= null;
			e.getMessage();
		}
		return alRoute;		
	}

	/** 
	 * @see com.ata.service.Customer#bookVehicle(com.ata.bean.ReservationBean)
	 * @param reservationBean Function Parameter
	 * @return String
	 */
	@Override
	public String bookVehicle(ReservationBean reservationBean) 
	{
		String result="FAIL";
		ReservationDAOImpl reserveDao = new ReservationDAOImpl();
		try
		{
			if(reservationBean!=null)
			{
				result=reserveDao.createReservation(reservationBean);	
			}
			else
			{
				result="FAIL";
			}
		}
		catch(Exception e)
		{
			result="ERROR";
			e.getMessage();
		}
		return result;		
	}

	/** 
	 * @see com.ata.service.Customer#cancelBooking(java.lang.String, java.lang.String)
	 * @param userID Function Parameter
	 * @param reservationID Function Parameter
	 * @return boolean
	 */
	@Override
	public boolean cancelBooking(String userID, String reservationID) 
	{
		boolean status=false;
		ReservationDAOImpl resDaoImpl= new ReservationDAOImpl();
		try
		{
			if((userID!=null)&&(reservationID!=null))
			{
				status=resDaoImpl.cancelBooking(userID, reservationID);
			}
			else
			{
				status=false;
			}
		}
		catch(Exception e)
		{
			status=false;
			e.getMessage();
		}		
		return status;			
	}

	/** 
	 * @see com.ata.service.Customer#viewBookingDetails(java.lang.String)
	 * @param reservationID Function Parameter
	 * @return ReservationBean
	 */
	@Override
	public ReservationBean viewBookingDetails(String reservationID) 
	{
		ReservationDAOImpl resDaoImpl=new ReservationDAOImpl();
		ReservationBean rBean = new ReservationBean();		
		try
		{
			if(reservationID!=null)
			{
				rBean = resDaoImpl.findByID(reservationID);
			}
			else
			{
				rBean=null;
			}
		}
		catch(Exception e)
		{
			rBean=null;
			e.getMessage();
		}			
		return rBean;		
	}

	/** 
	 * @see com.ata.service.Customer#printBookingDetails(java.lang.String)
	 * @param reservationID Function Parameter
	 * @return ReservationBean
	 */
	@Override
	public ReservationBean printBookingDetails(String reservationID) 
	{
		ReservationDAOImpl resDaoImpl=new ReservationDAOImpl();
		ReservationBean rBean = new ReservationBean();	
		try
		{
			if(reservationID!=null)
			{
				rBean = resDaoImpl.findByID(reservationID);
			}
			else
			{
				rBean=null;
			}
		}
		catch(Exception e)
		{
			rBean=null;
			e.getMessage();
		}			
		return rBean;
	}

	@Override
	public String forgotPassword(String userid,String ans) {
		String result="";
		
	 CredentialDAO credentialDAO=new CredentialDAOImpl();
	 result=credentialDAO.forgotPassword(userid,ans);
	 
	 return result;
	
	}

	
	
}
