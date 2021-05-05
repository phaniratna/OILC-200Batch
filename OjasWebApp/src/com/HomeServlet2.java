package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet2
 */
@WebServlet("/HomeServlet2")
public class HomeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println("<h1> Home Servlet 2 !!!</h1>");
         HttpSession session = request.getSession(false);
       if(session != null)   {
       String loginId = (String) session.getAttribute("loginId");
      out.println("<h2> Welcome " + loginId + " !!! </h2>");
      out.println("<br> Session ID :: " + session.getId() );
      out.println("<br> Session Creation Time :: " + 
              new java.util.Date(session.getCreationTime()));
      out.println("<br> Last Accessed Time :: " + 
              new java.util.Date(session.getLastAccessedTime()));      
       out.println("<br><br><br><br><br>");
      out.println("<a href='LogoutServlet'>Logout </a>");
       }
       else    {
           out.println("<h2> Session Expired...</h2>");
           out.println("<br><a href='login.html'> Login Again</a> ");
       }   out.close();

	}

}
