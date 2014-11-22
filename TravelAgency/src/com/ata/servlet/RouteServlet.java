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
 * Servlet implementation class RouteServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
     * @see HttpServlet#HttpServlet()
     */
    public RouteServlet() {
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
		HttpSession session = request.getSession();
		
		RouteBean rbean = new RouteBean();
		String routeIdFromJsp = request.getParameter("RouteID");		
		AdministratorImpl admImpl = new AdministratorImpl();
		
		rbean=admImpl.viewRoute(routeIdFromJsp);
		ServletContext sc = request.getServletContext();
		
		if(rbean!=null)
		{
			session.setAttribute("updatedRouteBean", rbean);	
			RequestDispatcher rd = sc.getRequestDispatcher("/updateroute.jsp");
			rd.forward(request, response);		
		}
		else
		{
			session.setAttribute("UpdateStatus", "Route Does not exists !!!");
			RequestDispatcher rd= sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	
	}

}
