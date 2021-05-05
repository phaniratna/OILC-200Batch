package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ExamDAO;
import com.model.Question;

/**
 * Servlet implementation class ScheduleExam
 */
@WebServlet("/ScheduleExam")
public class ScheduleExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		ArrayList<Question> q = ExamDAO.getQuestions();
	       pw.println( "<form action='d'>");
	       for(Question quest : q) {
	       pw.println( "  Question No :  "+quest.getQno()+"</p>");
	       pw.println( quest.getQuestion()+"<br></br>");
	        
	       pw.println( " <input type='radio' name='ans' value='1'> "+ 
	       quest.getAns1()+"&nbsp;&nbsp;<br>");
	       pw.println( " <input type='radio' name='ans' value='2'> "+ 
	       quest.getAns2()+"&nbsp;&nbsp;<br>");
	       pw.println( " <input type='radio' name='ans' value='3'> "+
	       quest.getAns3()+"&nbsp;&nbsp;<br>");
	       pw.println( " <input type='radio' name='ans' value='4'> "+ 
	       quest.getAns4()+"&nbsp;&nbsp;<br><br>");
	           
	       }
	       pw.println("<input type='submit' value='Next' name='action'/><br><br>"
	       		+ "&nbsp;&nbsp;");
	    
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
