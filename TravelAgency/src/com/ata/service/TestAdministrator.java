package com.ata.service;

import org.junit.Test;

/*import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.ReservationDAOImpl;
import com.wipro.ata.dao.VehicleDAOImpl;*/

/**
 * This test class is used to test the Administrator methods.
 * @version 1.0
 * @author Abhinav , Abhilash
 */


public class TestAdministrator 
{
/*	AdministratorImpl admImpl= new AdministratorImpl();*/
		
	@Test
	public void testAddVehicle() 
	{
	/*	VehicleBean vehicleBean = new VehicleBean();
	*/	
	/*	vehicleBean.setName("TOYOTA");
		vehicleBean.setType("AC");
		vehicleBean.setRegistrationNumber("Toyota-123");
		vehicleBean.setSeatingCapacity("6");
		vehicleBean.setFarePerKM(35);
		String result=admImpl.addVehicle(vehicleBean);
		assertEquals("SUCCESS",result);
	*/	
	/*	vehicleBean=null;
		String result=admImpl.addVehicle(vehicleBean);
		assertEquals("FAIL",result);
	*/	
	/*	vehicleBean.setName(null);
		vehicleBean.setType("AC");
		vehicleBean.setRegistrationNumber("UP14AK47");
		vehicleBean.setSeatingCapacity("7");
		vehicleBean.setFarePerKM(5);
		String result=admImpl.addVehicle(vehicleBean);
		assertEquals("ERROR",result);
	*/	
		
	}
	
	@Test
	public void testDeleteVehicle()
	{
		/*ArrayList<String> aList=new ArrayList<String>();*/
		/*
		aList.add("AB2345");
		int result=admImpl.deleteVehicle(aList);
		assertEquals(0, result);*/
	
	/*	aList.add("To1038");
		int result=admImpl.deleteVehicle(aList);
		assertEquals(1, result);*/
	
	/*	int result=admImpl.deleteVehicle(null);
		assertEquals(0, result);*/
	}
	
	@Test
	public void testViewVehicleId()
	{
		/*VehicleBean vehicleBean=new VehicleBean();*/
		
		/*vehicleBean=admImpl.viewVehicle("Au1000");
		assertNotNull(vehicleBean);*/
	
		/*vehicleBean=admImpl.viewVehicle("JK1000");
		assertNull(vehicleBean);*/
		
		/*vehicleBean=admImpl.viewVehicle(null);
		assertNull(vehicleBean);*/
		
	}
	
	@Test
	public void testModifyVehicle() 
	{
	/*	VehicleBean vehicleBean=new VehicleBean();
		vehicleBean.setVehicleID("Au1000");
		vehicleBean.setName("AUDI R8");
		vehicleBean.setSeatingCapacity("3");
		vehicleBean.setFarePerKM(30);
		vehicleBean.setRegistrationNumber("UP14AA1");
		vehicleBean.setType("AC");
		
		boolean actual=admImpl.modifyVehicle(vehicleBean);
		assertEquals(true, actual);
	*/	
		/*VehicleBean vehicleBean=new VehicleBean();
		vehicleBean.setVehicleID("AA1111");
		vehicleBean.setName("AUDI R8");
		vehicleBean.setSeatingCapacity("3");
		vehicleBean.setFarePerKM(30);
		vehicleBean.setRegistrationNumber("UP14AA1");
		vehicleBean.setType("AC");
		
		boolean actual=admImpl.modifyVehicle(vehicleBean);
		assertEquals(false, actual);
		*/
		
		/*VehicleBean vehicleBean=new VehicleBean();
		vehicleBean.setVehicleID("Au1000");
		vehicleBean.setName(null);
		vehicleBean.setSeatingCapacity("3");
		vehicleBean.setFarePerKM(30);
		vehicleBean.setRegistrationNumber("UP14AA1");
		vehicleBean.setType("AC");
		
		boolean actual=admImpl.modifyVehicle(vehicleBean);
		assertEquals(false, actual);*/
		
	/*	VehicleBean vehicleBean=new VehicleBean();
		vehicleBean=null;		
		boolean actual=admImpl.modifyVehicle(vehicleBean);
		assertEquals(false, actual);
*/		
	}
	
	
	@Test
	public void testAddRoute() 
	{
		/*RouteBean routeBean=new RouteBean();*/
	
	/*	routeBean.setDestination("DELHI");
		routeBean.setDistance(30);
		routeBean.setSource("GHAZIABAD");
		routeBean.setTravelDuration(4);
		String result=admImpl.addRoute(routeBean);
		assertEquals("SUCCESS",result); 
	*/
	/*	routeBean=null;
		String result=admImpl.addRoute(routeBean);
		assertEquals("FAIL",result); 
	*/
	/*	routeBean.setDestination(null);
		routeBean.setDistance(30);
		routeBean.setSource("GHAZIABAD");
		routeBean.setTravelDuration(4);
		String result=admImpl.addRoute(routeBean);
		assertEquals("ERROR",result); 
	*/
	
	}
	
	@Test
	public void testModifyRoute()
	{
		/*RouteBean routeBean=new RouteBean();*/
		/*routeBean.setRouteID("ChLu1005");
		routeBean.setSource("Chandigarh");
		routeBean.setDestination("Lucknow");
		routeBean.setDistance(700);
		routeBean.setTravelDuration(11);
		
		boolean actual=admImpl.modifyRoute(routeBean);
		assertEquals(true, actual);*/
		
		/*routeBean.setRouteID("CHCH1010");
		routeBean.setSource("Chandigarh");
		routeBean.setDestination("Lucknow");
		routeBean.setDistance(700);
		routeBean.setTravelDuration(11);
		
		boolean actual=admImpl.modifyRoute(routeBean);
		assertEquals(false, actual);*/
		
		/*routeBean.setRouteID("ChLu1005");
		routeBean.setSource(null);
		routeBean.setDestination("Lucknow");
		routeBean.setDistance(700);
		routeBean.setTravelDuration(11);
		
		boolean actual=admImpl.modifyRoute(routeBean);
		assertEquals(false, actual);*/
		
		/*routeBean=null;
		boolean actual=admImpl.modifyRoute(routeBean);
		assertEquals(false, actual);*/
		
	}
	
	@Test
	public void testViewRouteId() 
	{
		/*RouteBean routeBean=new RouteBean();*/
		/*routeBean=admImpl.viewRoute("ChLu1005");
		assertNotNull(routeBean);*/
	
		/*routeBean=admImpl.viewRoute("RRRR1000");
		assertNull(routeBean);*/
		
		/*routeBean=admImpl.viewRoute(null);
		assertNull(routeBean);*/
	
	}
	
	@Test
	public void testDeleteRoute()
	{
		/*ArrayList<String> aList=new ArrayList<String>();*/
		/*aList.add("GHRA1035");
		int result=admImpl.deleteRoute(aList);
		assertEquals(1, result);*/
		
	/*	aList.add("ABGH1024");
		int result=admImpl.deleteRoute(aList);
		assertEquals(0, result);*/
		
		/*int result=admImpl.deleteRoute(null);
		assertEquals(0, result);*/
		
	}
	
	public void testAddDriver()  
	{
		/*DriverBean driverBean=new DriverBean();*/
	/*	driverBean.setName("DRIVER");
		driverBean.setCity("HARDOI");
		driverBean.setLicenseNumber("HA2536");
		driverBean.setLocation("LUCKNOW");
		driverBean.setMobileNo("9876543210");
		driverBean.setPincode("201002");
		driverBean.setState("UTTAR PRADESH");
		driverBean.setStreet("WALL STREET");
		String result=admImpl.addDriver(driverBean);
		assertEquals("SUCCESS",result);
	*/	
	/*	driverBean=null;
		String result=admImpl.addDriver(driverBean);
		assertEquals("FAIL",result);
	*/
	/*	driverBean.setName(null);
		driverBean.setCity("HARDOI");
		driverBean.setLicenseNumber("HA2536");
		driverBean.setLocation("LUCKNOW");
		driverBean.setMobileNo("9876543210");
		driverBean.setPincode("201002");
		driverBean.setState("UTTAR PRADESH");
		driverBean.setStreet("WALL STREET");
		String result=admImpl.addDriver(driverBean);
		assertEquals("SUCCESS",result);
	*/
	}
	
	@Test
	public void testModifyDriver() 
	{
		/*DriverBean driverBean=new DriverBean();*/
		/*driverBean.setDriverID("Sa1003");
		driverBean.setName("Satpal Singh");
		driverBean.setCity("HARDOI");
		driverBean.setLicenseNumber("HA2536");
		driverBean.setLocation("LUCKNOW");
		driverBean.setMobileNo("9876543210");
		driverBean.setPincode("201002");
		driverBean.setState("UTTAR PRADESH");
		driverBean.setStreet("WALL STREET");
		
		boolean actual=admImpl.modifyDriver(driverBean);
		assertEquals(true, actual);*/
		
		/*driverBean.setDriverID("SA1000");
		driverBean.setName("Satpal Singh");
		driverBean.setCity("HARDOI");
		driverBean.setLicenseNumber("HA2536");
		driverBean.setLocation("LUCKNOW");
		driverBean.setMobileNo("9876543210");
		driverBean.setPincode("201002");
		driverBean.setState("UTTAR PRADESH");
		driverBean.setStreet("WALL STREET");
		
		boolean actual=admImpl.modifyDriver(driverBean);
		assertEquals(false, actual);*/
		
		/*driverBean.setDriverID("Sa1003");
		driverBean.setName(null);
		driverBean.setCity("HARDOI");
		driverBean.setLicenseNumber("HA2536");
		driverBean.setLocation("LUCKNOW");
		driverBean.setMobileNo("9876543210");
		driverBean.setPincode("201002");
		driverBean.setState("UTTAR PRADESH");
		driverBean.setStreet("WALL STREET");
		
		boolean actual=admImpl.modifyDriver(driverBean);
		assertEquals(false, actual);*/
		
	/*	driverBean=null;
		boolean actual=admImpl.modifyDriver(driverBean);
		assertEquals(false, actual);*/
	}
	
	@Test
	public void testDeleteDriver()
	{
		/*ArrayList<String> aList=new ArrayList<String>();*/
		/*aList.add("PA1013");
		int result=admImpl.deleteDriver(aList);
		assertEquals(1, result);*/
		
		/*aList.add("AB1024");
		int result=admImpl.deleteDriver(aList);
		assertEquals(0, result);*/
		
		/*int result=admImpl.deleteDriver(null);
		assertEquals(0, result);*/
		
	}
	
	@Test
	public void testAllotDriver()
	{
		/*boolean actual=admImpl.allotDriver("Gh1019","Sa1003");
		assertEquals(true, actual);*/
		
		/*boolean actual=admImpl.allotDriver(null,"Sa1003");
		assertNotEquals(true, actual);*/
		
		/*boolean actual=admImpl.allotDriver("Gh1019",null);
		assertNotEquals(true, actual);*/
		
		/*boolean actual=admImpl.allotDriver(null,null);
		assertNotEquals(true, actual);*/
		
	}
	
	@Test
	public void testViewBookingDetails()
	{
		/*ArrayList<ReservationBean> aList=new ArrayList<ReservationBean>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null;
		try 
		{
			dd = sdf.parse("2014-11-12");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		aList=admImpl.viewBookingDetails(dd, "asdf", "asd");
		assertNotNull(aList);*/
		
		/*ArrayList<ReservationBean> aList=new ArrayList<ReservationBean>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null;
		try 
		{
			dd = sdf.parse("2014-11-12");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		aList=admImpl.viewBookingDetails(dd, "asdf", "mcbc");
		assertNull(aList);*/
		
		/*ArrayList<ReservationBean> aList=new ArrayList<ReservationBean>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null;
		try 
		{
			dd = sdf.parse("2014-11-12");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		aList=admImpl.viewBookingDetails(null, "asdf", "mcbc");
		assertNull(aList);*/
		
		
	}
}
