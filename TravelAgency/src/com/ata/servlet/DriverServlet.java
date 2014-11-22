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

import com.ata.bean.DriverBean;
import com.ata.dao.DriverDAOImpl;


/**
 * Servlet implementation class DriverServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/DriverServlet")
public class DriverServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DriverServlet() {
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
	
		DriverBean dbean = new DriverBean();
		DriverDAOImpl driverDao = new DriverDAOImpl();
		String driverIdFromJsp = request.getParameter("driveID");
		
		boolean status=false;

		try
		{
			dbean=driverDao.findByID(driverIdFromJsp);
			if(dbean!=null)
			{

				status=true;
			}				
		}
		catch(SQLException e)
		{
			status=false;
			e.getMessage();
		}

		catch(Exception e)
		{
			status=false;
			e.getMessage();
		}

		if(status==true)
		{
			session.setAttribute("updatedDriverBean", dbean);

			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/updatedriver.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Driver Does not exists !!!");
			ServletContext scontext = request.getServletContext();
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	
	}
	
}
