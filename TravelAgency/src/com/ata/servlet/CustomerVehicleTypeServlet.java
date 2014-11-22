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

import com.ata.bean.VehicleBean;
import com.ata.service.CustomerImpl;

/**
 * Servlet implementation class CustomerVehicleTypeServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/CustomerVehicleTypeServlet")
public class CustomerVehicleTypeServlet extends HttpServlet {
	       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerVehicleTypeServlet() {
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
		String type=(String)request.getParameter("type");
		
		CustomerImpl cImplement = new CustomerImpl();
		ArrayList<VehicleBean> alVehicle = new ArrayList<VehicleBean>();
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();	
		boolean status=false;
		try 
		{
			alVehicle=cImplement.viewVehiclesByType(type);
			if(alVehicle!=null)
			{				
				status=true;
			}
			else
			{
				status=false;

			}
		} 
		catch (Exception e) 
		{
			status=false;
			e.getMessage();


		}
		if(status==true)
		{
			session.setAttribute("cVehicleLists", alVehicle);  
			RequestDispatcher rd = sc.getRequestDispatcher("/customerviewvehicle.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Some Error Occured, Please Try again !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);
		}	
	}
}
