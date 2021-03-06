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

import com.ata.service.AdministratorImpl;

/**
 * Servlet implementation class DriverDeleteServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/DriverDeleteServlet")
public class DriverDeleteServlet extends HttpServlet {
	      
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DriverDeleteServlet() {
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
		String id =request.getParameter("driverID");

		int deleteStatus=0;
		
		AdministratorImpl administratorImpl= new AdministratorImpl();
		
		ArrayList<String> aList=new ArrayList<String>();
		aList.add(id);
		
		deleteStatus=administratorImpl.deleteDriver(aList);
		HttpSession session = request.getSession();
		ServletContext scontext = request.getServletContext();
		if(deleteStatus==1)
		{			
			session.setAttribute("UpdateStatus", "Driver Deleted Successfully !!!");
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}		
		else
		{
			session.setAttribute("UpdateStatus", "Driver Cannot be deleted, since He has a booking !!!");
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}		
	}

	
}
