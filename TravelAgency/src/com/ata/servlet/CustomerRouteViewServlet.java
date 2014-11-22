package com.ata.servlet;

import java.io.IOException;
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
import com.ata.service.CustomerImpl;

/**
 * Servlet implementation class CustomerVehicleViewServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/CustomerRouteViewServlet")
public class CustomerRouteViewServlet extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRouteViewServlet() {
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
	
		String name=(String)request.getParameter("name");

		CustomerImpl cImplement = new CustomerImpl();
		ArrayList<RouteBean> alRoute = new ArrayList<RouteBean>();
		
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
				
		 if ("routes".equals(name))
		{
			alRoute=cImplement.viewAllRoutes();
			session.setAttribute("cRouteList", alRoute);  
			RequestDispatcher rd = sc.getRequestDispatcher("/customerviewroutes.jsp");
			rd.forward(request, response);
		}
		 else
			{
				session.setAttribute("UpdateStatus", "No Routes Available !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
				rd.forward(request, response);			
			}	
	}



}
