package com.ata.service;

import org.junit.Test;
/*
import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;*/

/**
 * This test class is used to test the Customer methods.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class TestCustomer {

/*	CustomerImpl cust=new CustomerImpl();*/
	
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testViewVehiclesByType()//COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED
	{
		/*ArrayList<VehicleBean> aList=new ArrayList<VehicleBean>();
		aList=cust.viewVehiclesByType("AC");
		assertNotNull(aList);*/
		
		/*ArrayList<VehicleBean> aList=new ArrayList<VehicleBean>();
		aList=cust.viewVehiclesByType(null);
		assertNull(aList);*/
		
		/*ArrayList<VehicleBean> aList=new ArrayList<VehicleBean>();
		aList=cust.viewVehiclesByType("ABCD");
		assertNull(aList);*/
		
	}
	
	@Test
	public void testViewVehiclesBySeats()//COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED
	{
		/*ArrayList<VehicleBean> aList=new ArrayList<VehicleBean>();
		aList=cust.viewVehicleBySeats(6);
		assertNotNull(aList);*/
		
	/*	ArrayList<VehicleBean> aList=new ArrayList<VehicleBean>();
		aList=cust.viewVehicleBySeats(0);
		assertNull(aList);*/
		
	}
	
	@Test
	public void testViewAllRoutes()//COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED
	{
	/*	ArrayList<RouteBean> aList=new ArrayList<RouteBean>();
		aList=cust.viewAllRoutes();
		assertNotNull(aList);
		*/
	}
	
	@Test
	public void testBookVehicle()//COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED COMPLETED
	{
		/*ReservationBean reservationBean=new ReservationBean();*/
		/*String actual;
		reservationBean.setUserID("Ja1002");
		reservationBean.setVehicleID("Au1000");
		reservationBean.setRouteID("ChLu1005");
		reservationBean.setReservationID("RA1238");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null,dd2=null;
		try 
		{
			dd = sdf.parse("2014-11-12");
			dd2 = sdf.parse("2014-11-14");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		reservationBean.setBookingDate(dd);
		reservationBean.setJourneyDate(dd2);
		
		reservationBean.setTotalFare(500);
		reservationBean.setDriverID("Ja1005");
		reservationBean.setBookingStatus("Pending");
		reservationBean.setBoardingPoint("Raipur");
		reservationBean.setDropPoint("Hardoi");
		
		actual=cust.bookVehicle(reservationBean);
		assertEquals("SUCCESS", actual);*/
		
		
		
		/*String actual;
		reservationBean.setUserID("Ja1002");
		reservationBean.setVehicleID(null);
		reservationBean.setRouteID("ChLu1005");
		reservationBean.setReservationID("RA1238");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null,dd2=null;
		try 
		{
			dd = sdf.parse("2014-11-12");
			dd2 = sdf.parse("2014-11-14");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		reservationBean.setBookingDate(dd);
		reservationBean.setJourneyDate(dd2);
		
		reservationBean.setTotalFare(500);
		reservationBean.setDriverID("Ja1005");
		reservationBean.setBookingStatus("Pending");
		reservationBean.setBoardingPoint("Raipur");
		reservationBean.setDropPoint("Hardoi");
		
		actual=cust.bookVehicle(reservationBean);
		assertEquals("ERROR", actual);*/
		
		/*String actual;
		reservationBean=null;		
		actual=cust.bookVehicle(reservationBean);
		assertEquals("FAIL", actual);*/
		
	}
	
	
	@Test
	public void testCancelBooking()
	{
		
		/*boolean actual;
		actual=cust.cancelBooking("Ja1002","Gh1019");
		assertEquals(true, actual);*/
		
		/*
		boolean actual;
		actual=cust.cancelBooking(null,"as1020");
		assertEquals(false, actual);*/
		
	/*	
		boolean actual;
		actual=cust.cancelBooking("Ja1002",null);
		assertEquals(false, actual);*/
		
	/*	boolean actual;
		actual=cust.cancelBooking(null,null);
		assertEquals(false, actual);
	*/
		
	/*	boolean actual;
		actual=cust.cancelBooking("Ja1072","Gh10w9");
		assertEquals(false, actual);
	*/
	}
	
	
	@Test
	public void testViewBookingDetails()
	{
		/*ReservationBean reservationBean= new ReservationBean();*/
		/*reservationBean=cust.viewBookingDetails(null);
		assertNull(reservationBean);*/
		
		/*reservationBean=cust.viewBookingDetails("Ch1022");
		assertNotNull(reservationBean);*/
		/*
		reservationBean=cust.viewBookingDetails("Ch9022");
		assertNull(reservationBean);
		*/
	}
	
	
	@Test
	public void testPrintBookingDetails()
	{
		/*ReservationBean reservationBean= new ReservationBean();*/
		
		/*reservationBean=cust.printBookingDetails(null);
		assertNull(reservationBean);
		*/
		
	/*	reservationBean=cust.printBookingDetails("Ch1022");
		assertNotNull(reservationBean);*/
		
		
	/*	reservationBean=cust.printBookingDetails("Ch9022");
		assertNull(reservationBean);*/
		
	}
	
}
