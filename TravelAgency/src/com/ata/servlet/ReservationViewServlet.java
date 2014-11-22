package com.ata.servlet;

import java.io.IOException;
import java.sql.SQLException;

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

/**
 * Servlet implementation class ReservationViewServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/ReservationViewServlet")
public class ReservationViewServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationViewServlet() {
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
		String reservationId = request.getParameter("resId");
		ReservationDAOImpl reservationDAOImpl= new ReservationDAOImpl();
		ReservationBean reservationBean= new ReservationBean();
		
		
		
		boolean status=false;
		

		
		
		try {
			
			if(reservationId!=null)
			{
				reservationBean=reservationDAOImpl.findByID(reservationId);
				status=true;
			}
			else
			{
				status=false;
			}
			
		
		} catch (SQLException e) 
		{
			status=false;
			e.getMessage();

		}
		catch (Exception e) 
		{
			status=false;
			e.getMessage();

		}
		
		HttpSession session=request.getSession();
		ServletContext sc= request.getServletContext();
		if(status==true)
		{
			session.setAttribute("cancelRes", reservationBean);
			RequestDispatcher rd=sc.getRequestDispatcher("/customerreservationdetails.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Select A Reservation Id !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);
		}
	
		
		
	}

}
