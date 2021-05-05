package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	Connection con = null;
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
		 int num = Integer.parseInt(request.getParameter("empno"));
		 String ename = request.getParameter("ename");
		 double salary = Double.parseDouble(request.getParameter("salary"));
		 pw.println("<body><form action=UpdateUser method=POST>");
		 pw.println("<h1 style=background-color:blue;color:white;padding:20px;text-align:center>"
		 		+ "Update User Information</h1>");
		 pw.println("<div>");
		 pw.println("<label>Enter Employee Number :</label><p/>");
		 pw.println("<input type=text name = empno value ="+num+ "><p/>");
		 pw.println("<label>Enter Employee Name :</label><p/>");
		 pw.println("<input type=text name = ename  value = " + ename + "><p/>");
		 pw.println("<label>Enter Employee Salary :</label><p/>");
		 pw.println("<input type=text name = salary value = " +salary+ "><p/>");
		 pw.println("<input type=submit value='Update Employee'/>");
		 pw.println("</div>");
		 pw.println("</form></body></html>");
		 
		 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		 PrintWriter pw = response.getWriter();
		 int num = Integer.parseInt(request.getParameter("empno"));
		 String ename = request.getParameter("ename");
		 double salary = Double.parseDouble(request.getParameter("salary"));
		 pw.println(""+ num + " " + ename + " " + salary);
		 try {
PreparedStatement pst = con.prepareStatement("update employee set ename = ? ,salary = ? where empno = ?");
			 pst.setString(1, ename);
			 pst.setDouble(2,salary);
			 pst.setInt(3, num);
			 int res = pst.executeUpdate();
			 if(res > 0 ) {
				 pw.println("<h1 style=color:green>Your record has been updated successfully</h1>");
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
