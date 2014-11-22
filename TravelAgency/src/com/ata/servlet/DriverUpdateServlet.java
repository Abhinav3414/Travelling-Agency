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
 * Servlet implementation class DriverUpdateServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/DriverUpdateServlet")
public class DriverUpdateServlet extends HttpServlet {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DriverUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @param request Function Parameter
	 * @param response Function Parameter
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @throws ServletException Throws any Servlet Exception
	 * @throws IOException Throws any IO Exception
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String id =request.getParameter("did");
		String name=request.getParameter("uname");
		String street=request.getParameter("ustreet");
		String location=request.getParameter("ulocation");
		String city=request.getParameter("ucity");
		String state=request.getParameter("ustate");
		String pinCode=request.getParameter("upincode");
		String mobileNo=request.getParameter("umno");
		String licenseNo=request.getParameter("ulno");
	
		DriverBean driverBean = new DriverBean();
	

		driverBean.setDriverID(id);
		driverBean.setName(name);
		driverBean.setStreet(street);
		driverBean.setLocation(location);
		driverBean.setCity(city);
		driverBean.setState(state);
		driverBean.setPincode(pinCode);
		driverBean.setMobileNo(mobileNo);
		driverBean.setLicenseNumber(licenseNo);
		HttpSession session= request.getSession();
		AdministratorImpl administratorImpl=new AdministratorImpl();
		boolean updateStatus=false;
		updateStatus=administratorImpl.modifyDriver(driverBean);
		
		if(updateStatus==true)
		{
			session.setAttribute("UpdateStatus", "Driver Updated Successfully !!!");
			ServletContext scontext = request.getServletContext();
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Driver Details Could Not Be Updated !!!");
			ServletContext scontext = request.getServletContext();
			RequestDispatcher rd= scontext.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		
	}

}
