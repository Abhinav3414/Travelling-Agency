package com.ata.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.CreditCardBean;
import com.ata.dao.ReservationDAOImpl;
import com.ata.util.Payment;

/**
 * Servlet implementation class PaymentServlet
 * @version 1.0
 * @author Abhinav , Abhilash
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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

		String creditCardNo=request.getParameter("cno");
		String validFrom=request.getParameter("validfrom");
		String validTo=request.getParameter("validto");
		String creditBalance=request.getParameter("creditbal");
		double creditBal = Double.parseDouble(creditBalance);

		HttpSession session = request.getSession();

		String userId =(String)session.getAttribute("userid");

		CreditCardBean cbean = new CreditCardBean();
		cbean.setCreditcardnumber(creditCardNo);
		cbean.setValidfrom(validFrom);
		cbean.setValidto(validTo);
		cbean.setCreditbalance(creditBal);
		cbean.setUserid(userId);
		boolean status=false;
		String result="fail";
		Payment payment=new Payment();

		ServletContext sc = request.getServletContext();

		status=payment.findByCardNumber(userId, creditCardNo);
		if(status==true)
		{
			result=payment.process(cbean);
			
			if("SUCCESS".equals(result))
			{

				boolean changeStatus=false;
				String reserveId=(String)session.getAttribute("resId");
				ReservationDAOImpl reservationDAOImpl= new ReservationDAOImpl();
				try 
				{
					changeStatus=reservationDAOImpl.changeBookingStatus(userId,reserveId);
				} 
				catch (SQLException e) 
				{					
					changeStatus=false;
					e.getMessage();

				} 
				catch (Exception e) 
				{
					changeStatus=false;
					e.getMessage();

				}
				
				if(changeStatus==true)
				{
					RequestDispatcher rd = sc.getRequestDispatcher("/confirmbooking.jsp");
					rd.forward(request, response);
				}
				else
				{
					session.setAttribute("UpdateStatus", "Reservation Status Could Not Be Saved, Please Contact Admin !!!");
					RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
					rd.forward(request, response);
				}
			
			
			}
			else if("FAIL".equals(result))
			{
				session.setAttribute("UpdateStatus", "Payment Processing Failed...Try Again !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
				rd.forward(request, response);
			}
			else 
			{					
				session.setAttribute("UpdateStatus", "Error Occurred During Payment...Try Again !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			session.setAttribute("UpdateStatus", "Credit card is Not Registered. Contact Admin !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);
		}
	}
}
