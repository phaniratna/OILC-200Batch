package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class RegUserServlet
 */
@WebServlet("/RegUserServlet")
public class RegUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con =  null;
    public RegUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ojasemployees",
					"root","root");
			System.out.println(con + "Connected Successfully");
		}
		catch(Exception e) {
				System.out.println(e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");    
		 PrintWriter pw = response.getWriter();
		 int num = Integer.parseInt(request.getParameter("empno").trim());
		 String ename = request.getParameter("ename").trim();     
		 double salary = Double.parseDouble(request.getParameter("salary").trim());
		 
		 try {
			 PreparedStatement pst = con.prepareStatement("insert into employee(empno,ename,salary) values (?,?,?)");
			 pst.setInt(1, num);
			 pst.setString(2, ename);
			 pst.setDouble(3,salary);
			 int res = pst.executeUpdate();
			 if(res > 0 ) {
				 pw.println("<h1 style=color:green>Your registration has been done successfully</h1>");
			 }
			 else {
				 pw.println("<h1 style=color:red>Try Again</h1>");
			 }
			 
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 
		 
		 
		 
		 
	}

}
