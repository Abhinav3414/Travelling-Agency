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





import com.ata.bean.VehicleBean;
import com.ata.dao.VehicleDAOImpl;

/**
 * Servlet implementation class VehicleViewServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/VehicleViewServlet")
public class VehicleViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleViewServlet() {
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

		VehicleDAOImpl vehicleDao = new VehicleDAOImpl();
		
		ArrayList<VehicleBean> alistVehicle= new ArrayList<VehicleBean>();
		
		boolean status=false;
		
		try 
		{
			if(alistVehicle!=null)
			{
				alistVehicle= vehicleDao.findAll();
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
		ServletContext sc = request.getServletContext();
	
		if(status==true)
		{
		
			session.setAttribute("vehicleList", alistVehicle);  
			RequestDispatcher rd = sc.getRequestDispatcher("/viewvehicle.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "No Vehicles Available !!!");
			RequestDispatcher rd= sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		
	}

	}
