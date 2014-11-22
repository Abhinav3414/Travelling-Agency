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






import com.ata.bean.RouteBean;
import com.ata.dao.RouteDAOImpl;

/**
 * Servlet implementation class RouteViewServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/RouteViewServlet")
public class RouteViewServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RouteViewServlet() 
	{
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
		RouteDAOImpl routeDao = new RouteDAOImpl();
		HttpSession session = request.getSession();
		ArrayList<RouteBean> alistRoute= new ArrayList<RouteBean>();
		boolean status=false;
		try 
		{
			alistRoute= routeDao.findAll();			
			if(alistRoute!=null)
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

		ServletContext sc = request.getServletContext();
		if(status==true)
		{
			session.setAttribute("routeList", alistRoute);  		
			RequestDispatcher rd = sc.getRequestDispatcher("/viewroute.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "No Routes Registered !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	}


	
}
