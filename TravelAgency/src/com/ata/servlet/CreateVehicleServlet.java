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
 * Servlet implementation class CreateVehicleServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/CreateVehicleServlet")
public class CreateVehicleServlet extends HttpServlet {
	       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CreateVehicleServlet() {
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

		String vehicleName=request.getParameter("name");
		String vehicleType=request.getParameter("type");
		String vehicleRno=request.getParameter("rnumber");
		String vehicleSeat=request.getParameter("capacity");
		String vehicleFare=request.getParameter("fpkm");

		Double vfare=Double.parseDouble(vehicleFare);
		VehicleBean vbean = new VehicleBean();

		// vehicle id cut
		vbean.setVehicleID("temp");
		vbean.setName(vehicleName);
		vbean.setType(vehicleType);
		vbean.setRegistrationNumber(vehicleRno);
		vbean.setSeatingCapacity(vehicleSeat);
		vbean.setFarePerKM(vfare);

		AdministratorImpl adminImplement = new AdministratorImpl();
		String finalStatus =adminImplement.addVehicle(vbean);

		if("SUCCESS".equals(finalStatus))
		{

			HttpSession session = request.getSession();
			session.setAttribute("UpdateStatus", "Vehicle Registered Successfully !!!");
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else if("FAIL".equals(finalStatus))
		{
			HttpSession session = request.getSession();
			session.setAttribute("UpdateStatus", "Vehicle Registeration Failed !!!");
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("UpdateStatus", "Some Error Occured, Please Try again !!!");
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	}
}
