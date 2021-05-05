package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintCookieServlet
 */
@WebServlet("/PrintCookieServlet")
public class PrintCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet PrintCookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet PrintCookieServlet at " + request.getContextPath () +
        		"</h1>");
       
        out.println("<h2>Cookie Details ...</h2>");
        
        Cookie [] cookie = request.getCookies();
        for(int i=0; i<cookie.length; i++)
        {
            out.println("Cookie Key/Name :" + cookie[i].getName() + "<br>");
            out.println("Cookie Value :: " + cookie[i].getValue() + "<br>");
        }
        
        out.println("</body>");
        out.println("</html>");
         
        out.close();

	}

}
