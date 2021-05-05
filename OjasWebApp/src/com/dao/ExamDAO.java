package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Question;

public class ExamDAO {
    public static ArrayList<Question> getQuestions() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ojasemployees",
					"root","root");
			System.out.println(con + "Connected Successfully");
            String query = "select * from questions ";
            System.out.println(query);
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Question> questions = new ArrayList<Question>();
            while (rs.next()) {
                Question q = new Question(rs.getString("qno"), rs.getString("question"),
                		rs.getString("ans1"), rs.getString("ans2"),
                        rs.getString("ans3"), rs.getString("ans4"), rs.getString("cans"));
                questions.add(q);
                System.out.println("Questions id " + q.getQno());
            }
            return questions;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        
    } 
}
    
    
    // end of getQuestions()
	 public static int processResult(ArrayList<Question> questions) {
          int count = 0;
          for(Question q : questions) {
              if (q.getAnswer().equals(q.getCans()))
                  count ++;
          }
          return count;
      }


}
