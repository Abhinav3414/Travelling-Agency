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





import com.ata.bean.VehicleBean;
import com.ata.service.AdministratorImpl;

/**
 * Servlet implementation class VehicleServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleServlet() {
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
		
		VehicleBean vbean = new VehicleBean();
		String vehicleIdFromJsp = request.getParameter("VehilceID");
		
		AdministratorImpl administratorImpl=new AdministratorImpl();
		vbean=administratorImpl.viewVehicle(vehicleIdFromJsp);
		ServletContext sc = request.getServletContext();
		if(vbean!=null)
		{
			session.setAttribute("updatedVehicleBean", vbean);
		
			RequestDispatcher rd = sc.getRequestDispatcher("/updatevehicle.jsp");
			rd.forward(request, response);		
		}
		else
		{
			session.setAttribute("UpdateStatus", "Vehicle Does not exists !!!");
			RequestDispatcher rd= sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}		
	}

	}
