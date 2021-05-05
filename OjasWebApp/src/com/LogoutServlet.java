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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
	       if(session != null) {
	    	   session.invalidate();
	    	   out.println("<br><a href='login.html'> Login Again</a> ");
	       }
	       else
	       {
	           out.println("<h2> Session Expired...</h2>");
	           out.println("<br><a href='login.html'> Login Again</a> ");
	       }
	}

}
