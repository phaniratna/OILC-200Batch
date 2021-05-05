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
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
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
        out.println("<title>Servlet CookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CookieServlet at " + request.getContextPath () + "</h1>");
        
        String luckyNo = request.getParameter("txtLuckyNo");
        Cookie cookie1 = new Cookie("LuckyNo" , luckyNo);
        //cookie1.setMaxAge(60*60);
        response.addCookie(cookie1);
        
        out.println("<a href='PrintCookieServlet'> Display Cookie </a>");
        
        out.println("</body>");
        out.println("</html>");
      
        out.close();
	}

}
