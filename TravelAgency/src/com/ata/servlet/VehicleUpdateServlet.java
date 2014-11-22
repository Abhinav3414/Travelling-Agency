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
 * Servlet implementation class VehicleUpdateServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/VehicleUpdateServlet")
public class VehicleUpdateServlet extends HttpServlet {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleUpdateServlet() {
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

		String id =request.getParameter("vid");
		String name=request.getParameter("vname");
		String type=request.getParameter("vtype");
		String regno=request.getParameter("vrno");
		String capacity=request.getParameter("vscap");
		String fpk=request.getParameter("vfpk");
	
		Double dfpk= Double.parseDouble(fpk);
		
		VehicleBean vehicleBean = new VehicleBean();
		vehicleBean.setVehicleID(id);
		vehicleBean.setName(name);
		vehicleBean.setType(type);
		vehicleBean.setRegistrationNumber(regno);
		vehicleBean.setSeatingCapacity(capacity);
		vehicleBean.setFarePerKM(dfpk);
	
		AdministratorImpl administratorImpl=new AdministratorImpl();
		boolean updateStatus=false;
		updateStatus=administratorImpl.modifyVehicle(vehicleBean);
		HttpSession session= request.getSession();
		if(updateStatus==true)
		{
			session.setAttribute("UpdateStatus", "Vehicle Updated Successfully !!!");
			ServletContext scontext = request.getServletContext();
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Vehicle Could Not Be Updated !!!");
			ServletContext scontext = request.getServletContext();
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	}

}
