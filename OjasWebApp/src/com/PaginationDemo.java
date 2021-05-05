package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaginationDemo
 */
@WebServlet("/PaginationDemo")
public class PaginationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    String name = "NEXT";
    public PaginationDemo() {
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
		 name =  request.getParameter("b1");
		 pw.println(name);
		
		 try {
				Statement pst = con.createStatement();
				ResultSet res = pst.executeQuery("select * from employee");
				if(name.equals("NEXT")) {
					boolean b = res.next();
					if(b == true) {
						pw.println("<tr><td>" + res.getInt(1)+"</td><td>"+res.getString(2)+"</td>");
						pw.println("<td>"+res.getDouble(3)+"</td><td>"+res.getDate(4)+"</td></tr");
					}
					else {
						pw.println("no record");
					}
				}
				if(name.equals("PREVIOUS")) {
					boolean b = res.previous();
					if(b == true) {
						pw.println("<tr><td>" + res.getInt(1)+"</td><td>"+res.getString(2)+"</td>");
						pw.println("<td>"+res.getDouble(3)+"</td><td>"+res.getDate(4)+"</td></tr");
					}
					else {
						pw.println("no record");
					}
				}
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	}

}
