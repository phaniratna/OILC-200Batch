package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSetMetaData;

/**
 * Servlet implementation class ListUsers
 */
@WebServlet("/ListUsers")
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUsers() {
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
		 pw.println("<h1 style=background-color:blue;color:white;padding:20px;text-align:center>Home Page</h1>");
		 
		 try {
			Statement pst = con.createStatement();
			ResultSet res = pst.executeQuery("select * from employee");
			ResultSetMetaData rsmd = res.getMetaData();
			pw.println("<table border = 1 align=center cellpadding = 10px bgcolor=wheat>");
			pw.println("<tr>");
			for(int i = 1; i <= rsmd.getColumnCount();i++) {
				pw.println("<td><font color= red>"+rsmd.getColumnName(i)+"</font></td>");
			}
			pw.println("</tr>");
			
			while(res.next()) {
				int num = res.getInt(1);
				String name = res.getString(2);
				double salary = res.getDouble(3);
				java.util.Date d1 =  res.getDate(4);
				//SimpleDateFormat s1 = new SimpleDateFormat("EE-MMMM-yy");
				//String date =  s1.format(d1);
				
				pw.println("<tr><td> " +num +"</td><td>"+ name);
				pw.println(" </td><td> " + salary + "</td><td>"+d1+"</td><td><a href=DeleteUser?empno="+num+
						">delete</a></td><td><a href=UpdateUser?empno="+num+"&ename="
						+name+"&salary="+salary+">update</a></td></tr>");
			}
			pw.println("</table>");
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
			 
	}

}
