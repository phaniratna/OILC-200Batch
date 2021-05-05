package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenServlet1
 */
@WebServlet("/servlet1")//url-pattern name of the server
public class HiddenServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  try{  
			  
		        response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
		          
		        String n=request.getParameter("userName");  
		        out.print("Welcome "+n);  
		          
		        //creating form that have invisible textfield  
		        out.print("<form action='servlet2'>");  
		        out.print("Mail :<input type='text' name='mail'>"); 
		        out.print("<input type='hidden' name='uname' value='"+n+"'>");  
		        out.print("<input type='submit' value='go'>");  
		        out.print("</form>");  
		        out.close();  
		  
		      }catch(Exception e){System.out.println(e);}  
		      
	}

}
