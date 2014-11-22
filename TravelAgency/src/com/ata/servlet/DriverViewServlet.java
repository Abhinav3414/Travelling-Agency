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

import com.ata.bean.DriverBean;
import com.ata.dao.DriverDAOImpl;

/**
 * Servlet implementation class DriverViewServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/DriverViewServlet")
public class DriverViewServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DriverViewServlet() {
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
		// Viewall
		
		DriverDAOImpl driverDao = new DriverDAOImpl();	
		ArrayList<DriverBean> alistDriver= new ArrayList<DriverBean>();		
		boolean status=false;
		try 
		{
			alistDriver= driverDao.findAll();			
			if(alistDriver!=null)
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

		HttpSession session = request.getSession();
		if(status==true)
		{
			session.setAttribute("driverList", alistDriver);  

			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/viewdriver.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "No Drivers Registered !!!");
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	}
}
