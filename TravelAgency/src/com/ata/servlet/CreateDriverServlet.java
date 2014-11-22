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

import com.ata.bean.DriverBean;
import com.ata.service.AdministratorImpl;

/**
 * Servlet implementation class CreateDriverServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/CreateDriverServlet")
public class CreateDriverServlet extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDriverServlet() {
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

		String name=request.getParameter("name");
		String street=request.getParameter("street");
		String location=request.getParameter("location");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pinCode=request.getParameter("pincode");
		String mobileNo=request.getParameter("mno");
		String licenseNo=request.getParameter("lno");
		
		DriverBean dbean = new DriverBean();
		
		dbean.setDriverID("temp");
		dbean.setName(name);
		dbean.setStreet(street);
		dbean.setLocation(location);
		dbean.setCity(city);
		dbean.setState(state);
		dbean.setPincode(pinCode);
		dbean.setMobileNo(mobileNo);
		dbean.setLicenseNumber(licenseNo);
		
		AdministratorImpl adminImplement = new AdministratorImpl();
		String finalStatus =adminImplement.addDriver(dbean);
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		
		if("SUCCESS".equals(finalStatus))
		{
			session.setAttribute("UpdateStatus", "Driver Registered Successfully !!!");			
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else if ("FAIL".equals(finalStatus))
		{
		
			session.setAttribute("UpdateStatus", "Driver Could Not be Registered !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Some Error Occured, Please Try again !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
	}

}
