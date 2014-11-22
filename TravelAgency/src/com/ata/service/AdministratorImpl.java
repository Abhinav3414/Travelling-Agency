package com.ata.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.DriverDAOImpl;
import com.ata.dao.ReservationDAOImpl;
import com.ata.dao.RouteDAOImpl;
import com.ata.dao.VehicleDAOImpl;

/**
 * This class is used to define various methods for Administrator
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class AdministratorImpl implements Administrator
{

	@Override
	public String addVehicle(VehicleBean vehicleBean) 
	{
		VehicleDAOImpl vehicleDao = new VehicleDAOImpl();	
		String result="FAIL";
		try
		{
			if(vehicleBean!=null)
			{
				result=vehicleDao.createVehicle(vehicleBean);
			}
			else
			{
				result="FAIL";
			}
		}
		catch(SQLException e)
		{
			result="ERROR";
			e.getMessage();
		}
		catch(Exception e)
		{
			result="ERROR";
			e.getMessage();
		}					
		return result;
	}

	@Override
	public int deleteVehicle(ArrayList<String> vehicleID)
	{
		int result=0;
		VehicleDAOImpl vehicleDao = new VehicleDAOImpl();
		try
		{
			if(vehicleID!=null)
			{
				result=vehicleDao.deleteVehicle(vehicleID);
			}
			else
			{
				result=0;
			}
		}
		catch(Exception e)
		{
			result=0;
			e.getMessage();
		}		
		return result;
	}

	@Override
	public VehicleBean viewVehicle(String vehicleID) 
	{
		VehicleBean vehicleBean=new VehicleBean();
		VehicleDAOImpl vehicleDAOImpl=new VehicleDAOImpl();
		try
		{
			if(vehicleID!=null)
			{
				vehicleBean=vehicleDAOImpl.findByID(vehicleID);
			}
			else
			{
				vehicleBean=null;
			}
		}
		catch(SQLException e)
		{
			vehicleBean=null;
			e.getMessage();
		}
		catch(Exception e)
		{
			vehicleBean=null;
			e.getMessage();
		}		
		return vehicleBean;	
	}

	@Override
	public boolean modifyVehicle(VehicleBean vehicleBean) 
	{
		boolean status=false;
		VehicleDAOImpl vehicleDAOImpl=new VehicleDAOImpl();	
		try
		{
			if(vehicleBean!=null)
			{
				status=vehicleDAOImpl.updateVehicle(vehicleBean);
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

	@Override
	public String addDriver(DriverBean driverBean) 
	{
		DriverDAOImpl driverDao = new DriverDAOImpl();
		String result="FAIL";
		try
		{
			if(driverBean!=null)
			{
				result=driverDao.createDriver(driverBean);
			}
			else
			{
				result="FAIL";
			}
		}
		catch(SQLException se)
		{
			result="ERROR";
			se.getMessage();
		}
		catch(Exception e)
		{
			result="ERROR";
			e.getMessage();
		}

		return result;
	}

	@Override
	public int deleteDriver(ArrayList<String> driverID) 
	{
		int result=0;
		DriverDAOImpl driverDao = new DriverDAOImpl();		
		try
		{
			if(driverID!=null)
			{
				result=driverDao.deleteDriver(driverID);
			}
			else
			{
				result=0;
			}
		}
		catch(Exception e)
		{
			result=0;
			e.getMessage();
		}	
		return result;
	}

	@Override
	public boolean allotDriver(String reservationID, String driverID) 
	{
		boolean status=false;
		ReservationDAOImpl resDaoImpl= new ReservationDAOImpl();	
		try
		{
			if((reservationID!=null)&&(driverID!=null))
			{
				status=resDaoImpl.allotDriver(reservationID, driverID);
			}
			else
			{
				status=false;
			}
		}
		catch(SQLException e)
		{
			status=false;
			e.getMessage();
		}
		catch(Exception e)
		{
			status=false;
			e.getMessage();
		}			
		return status;
	}

	@Override
	public boolean modifyDriver(DriverBean driverBean) 
	{
		boolean status=false;
		DriverDAOImpl daoImpl=new DriverDAOImpl();
		try
		{
			if(driverBean!=null)
			{
				status=daoImpl.updateDriver(driverBean);
			}
			else
			{
				status=false;
			}
		}
		catch(SQLException e)
		{
			status=false;
			e.getMessage();
		}
		catch(Exception e)
		{
			status=false;
			e.getMessage();
		}	
		
		return status;
	}

	@Override
	public String addRoute(RouteBean routeBean)
	{
		RouteDAOImpl routeDao = new RouteDAOImpl();
		String result="FAIL";
		try
		{
			if(routeBean!=null)
			{
				result=routeDao.createRoute(routeBean);
			}
			else
			{
				result="FAIL";
			}
		}
		catch(SQLException e)
		{
			result="ERROR";
			e.getMessage();
		}
		catch(Exception e)
		{
			result="ERROR";
			e.getMessage();
		}
		return result;
	}

	@Override
	public int deleteRoute(ArrayList<String> routeID) 
	{
		int result=0;
		RouteDAOImpl routeDao = new RouteDAOImpl();
		try
		{
			if(routeID!=null)
			{
				result=routeDao.deleteRoute(routeID);
			}
			else
			{
				result=0;
			}
		}
		catch(Exception e)
		{
			result=0;
			e.getMessage();
		}	
		return result;		
	}

	@Override
	public RouteBean viewRoute(String routeID) 
	{
		RouteBean routeBean=new RouteBean();
		RouteDAOImpl routeDAOImpl=new RouteDAOImpl();
		try
		{
			if(routeID!=null)
			{
				routeBean= routeDAOImpl.findByID(routeID);
			}
			else
			{
				routeBean=null;
			}
		}
		catch(Exception e)
		{
			routeBean=null;
			e.getMessage();
		}	
		return routeBean;
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean)
	{
		boolean status=false;
		RouteDAOImpl routeDAOImpl=new RouteDAOImpl();
		try
		{
			if(routeBean!=null)
			{
				status=routeDAOImpl.updateRoute(routeBean);
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

	@Override
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination) 
	{
		ReservationDAOImpl reservationDAOImpl= new ReservationDAOImpl();	
		ArrayList<ReservationBean> aReservationBeans= new ArrayList<ReservationBean>();
		try
		{
			if((journeyDate!=null)&&(source!=null)&&(destination!=null))
			{
				aReservationBeans=reservationDAOImpl.viewBookingDetails(journeyDate, source, destination);
			}
			else
			{
				aReservationBeans=null;
			}
		}
		catch(Exception e)
		{
			aReservationBeans=null;
			e.getMessage();
		}			
		return aReservationBeans;
	}


}
