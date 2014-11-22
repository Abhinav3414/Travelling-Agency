package com.ata.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.ProfileBean;
import com.ata.dao.ProfileDAOImpl;
import com.ata.util.UserImpl;

/**
 * Servlet implementation class RegisterServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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

		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
	
		
		String dd=request.getParameter("dd");
		String mm=request.getParameter("mm");
		String yyyy=request.getParameter("yyyy");
		
		String dateofBirth=dd+"-"+mm+"-"+yyyy;
		
		String gender=request.getParameter("gender");
		String street=request.getParameter("street");
		String location=request.getParameter("location");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pinCode=request.getParameter("pincode");
		String mobileNo=request.getParameter("mno");
		String emailId=request.getParameter("email");

		ProfileBean profileBean=new ProfileBean();

		//generating id
		ProfileDAOImpl pDao = new ProfileDAOImpl();
		String userId= 	pDao.generateId(firstName);
		profileBean.setUserID(userId);
		profileBean.setFirstName(firstName);
		profileBean.setLastName(lastName);
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd2=null;
		try 
		{
			dd2 = sdf.parse(dateofBirth);
		} 
		catch (ParseException e) 
		{
			e.getMessage();
		}
		profileBean.setDateOfBirth(dd2);
		profileBean.setGender(gender);
		profileBean.setStreet(street);
		profileBean.setLocation(location);
		profileBean.setCity(city);
		profileBean.setState(state);
		profileBean.setPincode(pinCode);
		profileBean.setMobileNo(mobileNo);
		profileBean.setEmailID(emailId);

		UserImpl userImplement = new UserImpl();
		ProfileDAOImpl profileDAOImpl=new ProfileDAOImpl();
		profileDAOImpl.registerCredentials(profileBean.getUserID());

		String registerStatus=userImplement.register(profileBean);
		ServletContext scontext = request.getServletContext();
		HttpSession session= request.getSession();

		if("SUCCESS".equals(registerStatus))
		{
			session.setAttribute("tempId", userId);
			RequestDispatcher rd = scontext.getRequestDispatcher("/registered.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("UpdateStatus", "Registration Could Not Be Completed  !!!");			
			RequestDispatcher rd = scontext.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);
		}
	}

}
