package com;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
//import java.util.*;
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet
{
		
Connection con =  null;
    

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

public void doGet(HttpServletRequest req,HttpServletResponse res)throws
ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();

	//int no=Integer.parseInt(req.getParameter("no"));
	String name=req.getParameter("name");
	String mail=req.getParameter("mail");
	String pwd=req.getParameter("pwd");
	String rpwd=req.getParameter("rpwd");
	String d=req.getParameter("ADate");
	String photo=req.getParameter("photo");
	if(pwd.equals(rpwd))
	{
	    
	try{
		
		File f=new File(photo);
		int size=(int)f.length();
		//System.out.println(size);
		FileInputStream fos=new FileInputStream(f);
			PreparedStatement ps3=con.prepareStatement(
			"select count(*) from stdregister");
			ResultSet rs3=ps3.executeQuery();
			String no;
			if(rs3.next())
			{
				no=	"2020OJA0"+(rs3.getInt(1)+1);
			}
			else
			{
				no="2020OJA01";
			}
			PreparedStatement ps1=con.prepareStatement(
					"insert into stdregister values(?,?,?,?,?)");
		ps1.setString(1,no);
		ps1.setString(2,name);
		ps1.setString(3,pwd);
		ps1.setString(4,mail);
		
		SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
		java.util.Date d1=new java.util.Date(d);
		java.sql.Date d2= new java.sql.Date(d1.getTime());
		ps1.setDate(5,d2);
		int x=ps1.executeUpdate();
		PreparedStatement ps=con.prepareStatement("insert into img values(?,?)");
		ps.setString(1,no);
		ps.setBinaryStream(2,fos,size);
		int x2=ps.executeUpdate();
	
		if(x!= 0&&x2 != 0)
		out.println("<body><h3><center>success fully insertd YOUR-ID:"+no+""
				+ "<br>PASSWORD:"+pwd+"</center></h3></body>");
		//ps1.setString(2,dob);
	}catch(Exception e)
	{ 
		e.printStackTrace();
	}	
	}
	else
	{
		res.sendRedirect("wrong.html");
	}
    	
			out.close();
		
	}//method
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
			doGet(req,res);
	}
}//service
	

