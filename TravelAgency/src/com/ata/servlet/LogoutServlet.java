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




import com.ata.util.UserImpl;

/**
 * Servlet implementation class LogoutServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		String uId =(String)session.getAttribute("userid");

		UserImpl userImplement = new UserImpl();
		boolean logoutStatus=false;
		logoutStatus=userImplement.logout(uId);

		if(logoutStatus==true)
		{
			session.invalidate();
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.invalidate();
			session.setAttribute("UpdateStatus", "Logout Not Successfull !!!");
			ServletContext scontext = request.getServletContext();
			RequestDispatcher rd= scontext.getRequestDispatcher("/alreadylogged.jsp");
			rd.forward(request, response);
		}
	}

	
}
