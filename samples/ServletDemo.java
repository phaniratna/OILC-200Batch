package com.ojas;
import java.io.*;
import javax.servlet.*;

public class ServletDemo extends GenericServlet {
	public void init(ServletConfig config)throws ServletException{
          System.out.println("Init method gets executed");
        }
        public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException {

           res.setContentType("text/html");
           PrintWriter pw = res.getWriter();
           pw.println("<h1 style=color:red>WELCOME TO OJAS</h1>");
        }
        public void destroy() {
		System.out.println("Destroy method gets executed");
        }

}