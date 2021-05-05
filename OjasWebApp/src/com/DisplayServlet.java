package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

	Connection con =  null;
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				PrintWriter pw=response.getWriter();	
							
				try	{				
					
			  PreparedStatement st=con.prepareStatement("select photo from img where no=?");
			  st.setString(1,"2020OJA01");
				ResultSet rs=st.executeQuery();
				if(rs.next())
				{  
					InputStream in=rs.getBinaryStream("photo");
					FileOutputStream fos=new FileOutputStream("d:\\xxx.jpeg");
	
					byte size[]=new byte[47232];
					int bytes=0;
					while((bytes=in.read(size))!=-1)
						fos.write(size,0,bytes);
				}
				pw.println("<body bgcolor='lightgreen'><div align='center'>"
						+ "<IMG SRC='d:\\xxx.jpeg' WIDTH='175' HEIGHT='200' BORDER='1' ALT=''></div></body>");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	  
	      
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}

}
