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
 * Servlet implementation class RouteUpdateServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/RouteUpdateServlet")
public class RouteUpdateServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
     * @see HttpServlet#HttpServlet()
     */
    public RouteUpdateServlet() {
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
		String rId =request.getParameter("rid");
		String rSource=request.getParameter("source");
		String rDestination=request.getParameter("destination");
		String rDistance=request.getParameter("distance");
		String rDuration=request.getParameter("duration");
		
		Double routeDistance=Double.parseDouble(rDistance); 
		Double routeDuration=Double.parseDouble(rDuration);
		
		RouteBean routeBean = new RouteBean();
	
		routeBean.setRouteID(rId);
		routeBean.setSource(rSource);
		routeBean.setDestination(rDestination);
		routeBean.setDistance(routeDistance);
		routeBean.setTravelDuration(routeDuration);
		
		AdministratorImpl administratorImpl=new AdministratorImpl();
		boolean updateStatus=false;
		updateStatus=administratorImpl.modifyRoute(routeBean);

		HttpSession session=request.getSession();
		ServletContext scontext = request.getServletContext();

		if(updateStatus==true)
		{
			session.setAttribute("UpdateStatus", "Route Updated Successfully !!!");
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Route Could Not Be Updated !!!");
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	}

}
