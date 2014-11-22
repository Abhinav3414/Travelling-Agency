package com.ata.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ata.service.AdministratorImpl;

/**
 * Servlet implementation class ReservationViewAllServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/ReservationViewAllServlet")
public class ReservationViewAllServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationViewAllServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdministratorImpl administratorImpl= new AdministratorImpl();
		
		ArrayList<ReservationBean> alistReservation= new ArrayList<ReservationBean>();
		String dd=request.getParameter("dd");
		String mm=request.getParameter("mm");
		String yyyy=request.getParameter("yyyy");	
		String date=dd+"-"+mm+"-"+yyyy;
		
		String boardingpoint=request.getParameter("board");
		String droppingpoint=request.getParameter("drop");
	
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd2=null;
		try 
		{
			dd2 = sdf.parse(date);
		} 
		catch (ParseException e) 
		{
			e.getMessage();
		}
		
		alistReservation= administratorImpl.viewBookingDetails(dd2, boardingpoint, droppingpoint);
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		
		if(alistReservation!=null)
		{
			session.setAttribute("reservationList", alistReservation);  			
			RequestDispatcher rd = sc.getRequestDispatcher("/viewallres.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "No Reservations Available !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	}


}
