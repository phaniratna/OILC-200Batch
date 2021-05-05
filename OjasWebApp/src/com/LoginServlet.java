package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    Connection con =  null;
	public void init(ServletConfig config) throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ojasemployees",
				"root","root");
		System.out.println(con + "Connected Successfully");
	}
	catch(Exception e) {
			System.out.println(e);
	}
}
	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		PrintWriter pw=response.getWriter();	
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		try	{				
	  PreparedStatement st=con.prepareStatement(
		"select * from stdregister where no = ? && pwd = ?");
	   st.setString(1, uname);
	   st.setString(2, upass);
	   ResultSet res = st.executeQuery();
	   if(res.next()) {
		   response.sendRedirect(
		"http://localhost:8080/OjasWebApp/ListUsers");
	   }
	   else {
		   response.sendRedirect("./LoginPage.html");
	   }
	   
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
