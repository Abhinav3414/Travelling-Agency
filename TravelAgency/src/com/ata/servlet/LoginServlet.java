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

import com.ata.bean.CredentialsBean;
import com.ata.util.UserImpl;

/**
 * Servlet implementation class LoginServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String uname= request.getParameter("uname");
		String pwd=request.getParameter("pass");
		
		HttpSession session=request.getSession();
		session.setAttribute("UpdateStatus", "None");
		session.setAttribute("viewallstatus", "None");
		
		session.setAttribute("userid",uname );
		
		CredentialsBean cbean= new CredentialsBean();		
		UserImpl u = new UserImpl();
		cbean.setUserID(uname);
		cbean.setPassword(pwd);
	
		String status= u.login(cbean);
		ServletContext sc = request.getServletContext();
		
		if("A".equals(status))
		{
			RequestDispatcher rd = sc.getRequestDispatcher("/adminhome.jsp");
			rd.forward(request, response);
		}
		else if("C".equals(status))
		{
			RequestDispatcher rd = sc.getRequestDispatcher("/userhome.jsp");
			rd.forward(request, response);
		}
		else if("FAIL".equals(status))
		{
			session.setAttribute("UpdateStatus", "Invalid User Id And Password !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/beforelogin.jsp");
			rd.forward(request, response);						
		}
		else
		{
			session.setAttribute("UpdateStatus", "Invalid User Id And Password !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/beforelogin.jsp");
			rd.forward(request, response);	
		}
	}
}
