package com.ata.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.RouteBean;
import com.ata.service.AdministratorImpl;

/**
 * Servlet implementation class CreateRouteServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/CreateRouteServlet")
public class CreateRouteServlet extends HttpServlet {
	       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRouteServlet() {
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

		String routeSource=request.getParameter("source");
		String routeDestination=request.getParameter("destination");
		String routeDistance=request.getParameter("distance");
		String routeDuration=request.getParameter("duration");	
		
		Double rDistance=Double.parseDouble(routeDistance);
		Double rDuration=Double.parseDouble(routeDuration);

		RouteBean rbean = new RouteBean();
		
		//generating route id
		
		
		rbean.setRouteID("temp");
		rbean.setSource(routeSource);
		rbean.setDestination(routeDestination);
		rbean.setDistance(rDistance);;
		rbean.setTravelDuration(rDuration);
		
		if(routeSource.equals(routeDestination))
		{
			RequestDispatcher rd =request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			System.out.println("source and destination cannot be same");
		}
		else
		{
		AdministratorImpl adminImplement = new AdministratorImpl();
		String finalStatus =adminImplement.addRoute(rbean);
		if("SUCCESS".equals(finalStatus))
		{

			HttpSession session = request.getSession();
			session.setAttribute("UpdateStatus", "Route Registered Successfully !!!");
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else if ("FAIL".equals(finalStatus))
		{
			HttpSession session = request.getSession();
			session.setAttribute("UpdateStatus", "Route Could Not be Registered !!!");
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("UpdateStatus", "Some Error Occured, Please Try again !!!");
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}			
	}
	}
}
	
