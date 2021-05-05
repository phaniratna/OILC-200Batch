package com.emps;


import java.io.*;

import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class PageServlet extends HttpServlet {
   
	Connection con =null;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          Connection con=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int count=0,i=1;
         
          
         
            PreparedStatement ps=con.prepareStatement
                    ("select empno,ename,sal from emp",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();
             PreparedStatement ps1=con.prepareStatement("select count(*) from emp");
                        ResultSet rs1=ps1.executeQuery();
                        if(rs1.next())
                        {
                            count=rs1.getInt(1);
                        }
                        
               HttpSession ses=request.getSession();
               String page=request.getParameter("page"); 
               out.println(page);
               String value=(String)ses.getAttribute("i");
               if(value!=null)
               {
                    i=Integer.parseInt(value);
               }
                if("next".equals(page))
                {
                    i++;
                }
                else if("previous".equals(page))
                {
                    i--;
                }
               else if("last".equals(page))
                {
                    i=count;
                }
                
              
               else if("first".equals(page))
                {
                    i=1;
                }
				if(i>count)
				{
					i=count;
                                }
                                if(i<1)
                                {
                                    i=1;
                                }
               ses.setAttribute("i",""+i+"");
                      
                        out.println("<body bgcolor='cyan'><form action='PageServlet'>");
                          out.println("<center>welcome employee details<br>");
                          
                          if(rs.absolute(i))
                          {
                          out.println("eno:<input type='text'name='eno' value="+rs.getInt(1)+"><br>");
                          out.println(" ename:<input type='text' name='ename' value="+rs.getString(2)+"><br>");
                          out.println(" esal:<input type='text' name='esal' value="+rs.getString(3)+"><br>");
                          
                          out.println("<input type='submit' value='first' name='page'>");
                            out.println("<input type='submit' value='previous' name='page'>");
                             out.println("<input type='submit' value='next' name='page'>");
                            out.println("<input type='submit' value='last'name='page'>");
                          }
                            out.println("</center>");
                           out.println("</form></body>");
                              
          }catch(Exception e)
            {
                        System.out.println(e);
             }
             
        }
        
      
        
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
