package com.ata.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.ReservationBean;
import com.ata.dao.ReservationDAOImpl;
import com.ata.service.AdministratorImpl;
import com.ata.service.CustomerImpl;

/**
 * Servlet implementation class ReservationServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @param request Function Parameter
	 * @param response Function Parameter
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @throws ServletException Throws any Servlet Exception
	 * @throws IOException Throws any IO Exception
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	
		String resId= request.getParameter("resId");
		String userId= request.getParameter("uid");
		String vehicleId= request.getParameter("vid");
		String routeId= request.getParameter("rid");
		String bookingdate= request.getParameter("bookdate");
		String jdate= request.getParameter("jdate");
		String driverId= request.getParameter("driverid");
		String bookstatus= request.getParameter("status");
		String tfare= request.getParameter("totalfare");
		String board= request.getParameter("boarding");
		String drop= request.getParameter("drop");
		
		ReservationBean reBean = new ReservationBean();
		reBean.setReservationID(resId);
		reBean.setUserID(userId);
		reBean.setVehicleID(vehicleId);
		reBean.setRouteID(routeId);
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null;
		Date dd2=null;
		try 
		{
			dd = sdf.parse(bookingdate);
			dd2= sdf.parse(jdate);
		} 
		catch (ParseException e) 
		{
			e.getMessage();
		}
		
		
		reBean.setBookingDate(dd);
		reBean.setJourneyDate(dd2);
		reBean.setDriverID(driverId);
		reBean.setBookingStatus(bookstatus);	
		double totalfare = Double.parseDouble(tfare);		
		reBean.setTotalFare(totalfare);
		reBean.setBoardingPoint(board);
		reBean.setDropPoint(drop);
		
		boolean status=false;
		ServletContext sc = request.getServletContext();
		HttpSession session= request.getSession();
		
		if("approved".equals(bookstatus))
		{
			AdministratorImpl administratorImpl= new AdministratorImpl();
			status=administratorImpl.allotDriver(reBean.getReservationID(),reBean.getDriverID());

			if(status==true)
			{
				session.setAttribute("UpdateStatus", "Driver Alloted Successfully !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("UpdateStatus", "Driver Could Not Be Allotted !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			session.setAttribute("UpdateStatus", "Select Approve option to Allot Driver !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @param request Function Parameter
	 * @param response Function Parameter
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @throws ServletException Throws any Servlet Exception
	 * @throws IOException Throws any IO Exception
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String vehicleId=request.getParameter("vehicleid");
		String routeId=request.getParameter("routeid");
		String bookingDate=request.getParameter("bookdate");
		
	
		String dd=request.getParameter("dd");
		String mm=request.getParameter("mm");
		String yyyy=request.getParameter("yyyy");
		
		String journeyDate=dd+"-"+mm+"-"+yyyy;
		
		String boardingPoint=request.getParameter("boarding");
		String droppingPoint=request.getParameter("dropping");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd3=null;
		Date dd2=null;
		try 
		{
			dd3 = sdf.parse(bookingDate);
			dd2= sdf.parse(journeyDate);
		} 
		catch (ParseException e) 
		{
			e.getMessage();
		}
		
		
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		if(dd2.after(dd3))
		{
			
		
		ReservationBean resBean = new ReservationBean();
		resBean.setBookingDate(dd3);
		resBean.setJourneyDate(dd2);		
		
		//generating reservating id
		ReservationDAOImpl resDao = new ReservationDAOImpl();
		
		String reservationId= resDao.generateId(routeId);
	
		resBean.setReservationID(reservationId);
		
		
		String userId =(String)session.getAttribute("userid");	
		session.setAttribute("resId",reservationId);

		resBean.setUserID(userId);
		resBean.setVehicleID(vehicleId);
		resBean.setRouteID(routeId);
		resBean.setDriverID("Du1006");
		resBean.setBookingStatus("To be paid");
		
		// calculate fare
		ReservationDAOImpl reDaoImpl = new ReservationDAOImpl();
		double fare=reDaoImpl.calculateTravelFare(vehicleId, routeId);
		
		session.setAttribute("sessionfare",fare);
		
		resBean.setTotalFare(fare);
		resBean.setBoardingPoint(boardingPoint);
		resBean.setDropPoint(droppingPoint);		
		
		String status="FAIL";
		
		CustomerImpl customerImpl= new CustomerImpl();
		status=customerImpl.bookVehicle(resBean);
		
	
		if("SUCCESS".equals(status))
		{
			
			RequestDispatcher rd = sc.getRequestDispatcher("/payment.jsp");
			rd.forward(request, response);			
		}
		else if("FAIL".equals(status))
		{		
			session.setAttribute("UpdateStatus", "Payment Could Not be Completed !!!");			
			RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);		
		}
		else
		{
			session.setAttribute("UpdateStatus", "Some Error Occured, PLease try Again !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);			
		}
		
		
		
		}
		else
		{
			session.setAttribute("UpdateStatus", "Select Appropriate Date of Journey !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);	
		}
		
		
		
	}
}
