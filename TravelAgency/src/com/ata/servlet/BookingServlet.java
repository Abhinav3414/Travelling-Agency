package com.ata.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;





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
import com.ata.service.CustomerImpl;

/**
 * Servlet implementation class BookingServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingServlet() {
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
		ServletContext sc = request.getServletContext();
		HttpSession session = request.getSession();
		String userid= (String)session.getAttribute("userid");

		String name="z";
		name=request.getParameter("name");

		if("view".equals(name))
		{
			ReservationDAOImpl resDao = new ReservationDAOImpl();
			ArrayList<ReservationBean> alReservation= new ArrayList<ReservationBean>();

			boolean status=false;

			try 
			{
				alReservation= resDao.findAllByID(userid);
				if(alReservation!=null)
				{
					status=true;
				}
			} 
			catch (SQLException e) 
			{
				status=false;
				e.getMessage();

			} 
			catch (Exception e) 
			{
				status=false;
				e.getMessage();
			}

			if(status==true)
			{
				session.setAttribute("resList", alReservation);  

				RequestDispatcher rd = sc.getRequestDispatcher("/reservationdetails.jsp");
				rd.forward(request, response);	
			}
			else
			{
				session.setAttribute("UpdateStatus", "Some Error Occured, PLease try Again !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
				rd.forward(request, response);			
			}
		}


		if("delete".equals(name))
		{
			String reservationID=request.getParameter("resid");
		    CustomerImpl customerImpl= new CustomerImpl();
			boolean status=false;
			status=customerImpl.cancelBooking(userid, reservationID);

			if(status==true)
			{		
				session.setAttribute("UpdateStatus", "Booking Cancelled Successfully !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
				rd.forward(request, response);		
			}	
			else
			{
				session.setAttribute("UpdateStatus", "Booking Could Not Be Cancelled !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
				rd.forward(request, response);			
			}
		}
	}
}
