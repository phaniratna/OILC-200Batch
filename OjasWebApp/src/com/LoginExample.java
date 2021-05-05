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
 * Servlet implementation class LoginExample
 */
@WebServlet("/LoginExample")
public class LoginExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        String login = request.getParameter("txtLoginID");
        String pwd = request.getParameter("txtPassword");
                
        if(login.equals(pwd)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loginId",login);
           // session.setMaxInactiveInterval(1*60);
         response.sendRedirect("HomeServlet");   
     
        } else {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<H2> Invalid Login! </h2>");
            pw.println("<a href='login.html'>Try Again</a>");
            pw.close();            
        }

	}

}
