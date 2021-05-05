package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 HttpSession session =null;
	    String pcode,qty,clickButton;
	double sum = 0.0;
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    
    	
    }
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int items[] = {101,102,103,104,105};
		   double prices[] = {100,200,2,5,7};
		    session = request.getSession(true);
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        clickButton=request.getParameter("submit");
	        if(clickButton.equals("ADDITEM"))
	        {
	              pcode=request.getParameter("pcode");
	              qty=request.getParameter("qty");
	              if(!pcode.equals("")||qty.equals(""))
	              {
	                  session.setAttribute(pcode,qty);
	                  response.sendRedirect("Shop.html");
	              }
	        }
	        if(clickButton.equals("REMOVEITEM"))
	        {
	             pcode=request.getParameter("pcode");
	             session.removeAttribute(pcode);
	             response.sendRedirect("Shop.html");
	        }
	        if(clickButton.equals("SHOWITEMS"))
	        {
	            java.util.Enumeration e=session.getAttributeNames();
	            if(e.hasMoreElements())
	            {
	        out.println("<h2><font color=blue>Your shopping cart items</font></h2>");
	                 while(e.hasMoreElements())
	                 {
	                     out.println("<body bgcolor=cyan>");
	                     String code=(String)e.nextElement();
	                     out.println("<h2>PRODUCT CODE"+code);
	                     out.println("QUANTITY:"+session.getAttribute(code));
	                  
	                 }
	            }
	            else
	            {
	                out.println("<body bgcolor=cyan>");
	                out.println("<h2><font color=red>NO ITEMS PLEASE</font></h2>");
	            }
	            
	        }
	        if(clickButton.equals("LOGOUT"))
	        {
	             session.invalidate();
	             response.sendRedirect("Shop.html");
	        }
	        if(clickButton.equals("PAYAMOUNT"))
	        {
	            out.println("<BODY BGCOLOR=yellow>");
	        out.println("<h2><font color=red>Payment logic goes here</font></h2>");
	        java.util.Enumeration e=session.getAttributeNames();
            if(e.hasMoreElements())
            {
        out.println("<h2><font color=blue>Your shopping cart items</font></h2>");
                 while(e.hasMoreElements())
                 {
                     out.println("<body bgcolor=cyan>");
                     String code=(String)e.nextElement();
                     int code1 = Integer.parseInt(code);
                    int value = Integer.parseInt((String)session.getAttribute(code));
                    
                    for(int i = 0; i < items.length;i++) {
                    	if(code1 == items[i]) {
                    		sum += prices[i] * value;
                    	}
                    }
                  
                 }
                 out.println("<h2><font color=blue> Total Price = "+sum+"</font></h2>");
            }
            else
            {
                out.println("<body bgcolor=cyan>");
                out.println("<h2><font color=red>NO ITEMS PLEASE</font></h2>");
            }
	        }
	        out.close();
	}

}
