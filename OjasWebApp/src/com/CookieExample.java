package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieExample
 */
@WebServlet("/CookieExample")
public class CookieExample extends HttpServlet {
	
	 static int i=1;
	 static int j=1;
   	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        String shirt=request.getParameter("shirt");
		        String book=request.getParameter("book");
		        Cookie c1=new Cookie("shirt"+i,shirt);
		        Cookie c2=new Cookie("book"+j,book);
		        response.addCookie(c1);
		        response.addCookie(c2);
		        i++;
		        j++;
		        out.println("<h3>Items in the shoping cart are</h3>");
		        out.println("<h3>"+c1.getName()+":"+shirt+"</h3>");
		        out.println("<h3>"+c2.getName()+":"+book+"</h3>");
		        Cookie c[]=request.getCookies();
		        if(c!=null)
		        {
		            for(int i=0;i<c.length;i++)
		            {
		                out.println("<h3>"+c[i].getName()+":"+c[i].getValue()+"</h3>");
		            }
		        }
		        RequestDispatcher rd=request.getRequestDispatcher("/CookieDemo.html");
		        rd.include(request,response);
		        out.close();
	}

}
