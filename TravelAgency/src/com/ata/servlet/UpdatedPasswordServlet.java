package com.ata.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.CredentialsBean;
import com.ata.dao.CredentialDAOImpl;
import com.ata.service.Customer;
import com.ata.service.CustomerImpl;

/**
 * Servlet implementation class UpdatedPasswordServlet
 */
@WebServlet("/UpdatedPasswordServlet")
public class UpdatedPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatedPasswordServlet() {
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
		// TODO Auto-generated method stub
		String password=request.getParameter("newpassword");
	    CredentialDAOImpl credentialDAOImpl = new CredentialDAOImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		HttpSession session=request.getSession();
		credentialsBean.setUserID((String)session.getAttribute("userid"));
	
	    		 if(password.length()>=4)
	    			{		
	    				String status = credentialDAOImpl.updatePassword(credentialsBean, password);
	    			
	    				if("SUCCESS".equals(status))
	    				
	    				{	
	    				
	    					RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
	    					rd.forward(request, response);		
	    				}
	    				else
	    				{
	    					
	    					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	    					rd.forward(request, response);
	    				}
	    			
	    			}
	    			
	    		}
}
