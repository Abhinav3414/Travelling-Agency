package com.ata.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.dao.CredentialDAOImpl;
import com.ata.service.Customer;
import com.ata.service.CustomerImpl;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		  String userid=request.getParameter("userid");
			session.setAttribute("userid",userid);
	    System.out.println("userid"+userid);
	    
	    String ans=request.getParameter("ans");
	    System.out.println("ans"+ans);
		Customer customer=new CustomerImpl();
		String status=customer.forgotPassword(userid, ans);
		System.out.println(status);
	
		if("SUCCESS".equals(status))
			
		{	
			RequestDispatcher rd =request.getRequestDispatcher("updated.jsp");
			rd.forward(request, response);		
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	
	}
		
}