package com.emps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

/**
 * Servlet implementation class ShopExample
 */
@WebServlet("/ShopExample")
public class ShopExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		ArrayList<Product> cart  = (ArrayList<Product>)session.getAttribute("cart");
		String pname = request.getParameter("pname");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ojasemployees",
					"root","root");
			System.out.println(con + "Connected Successfully");
			PreparedStatement pst = con.prepareStatement(
					"select * from product where pname = ?");
			pst.setString(1,pname );
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				cart.add(new Product(res.getInt(1),res.getString(2),
						res.getDouble(3)));
			}
			pw.println("product is added to the cart successfully ");
			pw.println("<br> You want shop more <a href=OnlineShop.html>Click </a>here</p>");
			pw.println("View cart data <a href=DisplayCart>list products</a>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		

		
	}

}
