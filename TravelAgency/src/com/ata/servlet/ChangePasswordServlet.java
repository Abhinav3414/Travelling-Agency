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
import com.ata.dao.CredentialDAOImpl;

/**
 * Servlet implementation class ChangePasswordServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		HttpSession session=request.getSession();
		String userId = (String) session.getAttribute("userid");
		String password=request.getParameter("newpass");
		CredentialDAOImpl credentialDAOImpl = new CredentialDAOImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		ServletContext sc = request.getServletContext();
		credentialsBean.setUserID(userId);
		
		System.out.println(password.length());
		if(password.length()>=4)
		{		
			String status = credentialDAOImpl.changePassword(credentialsBean, password);
		
			if("SUCCESS".equals(status))
			
			{	
				session.invalidate();
				RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);		
			}
			else
			{
				session.setAttribute("UpdateStatus", "Password Could Not be Changed !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		
		}
		else
		{
			session.setAttribute("UpdateStatus", "Password Must Be Atleast of 4 Characters  !!!");
			session.invalidate();
			RequestDispatcher rd = sc.getRequestDispatcher("/beforelogin.jsp");
			rd.forward(request, response);
		}
	}
}
