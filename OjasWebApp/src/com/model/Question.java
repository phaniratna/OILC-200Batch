package com.model;
public class Question {
	   private String qno, question, ans1, ans2, ans3, ans4, cans, answer;

	    public String getAnswer() {
	        return answer;
	    }

	    public void setAnswer(String answer) {
	        this.answer = answer;
	    }

	    public String getAns1() {
	        return ans1;
	    }

	    public void setAns1(String ans1) {
	        this.ans1 = ans1;
	    }

	    public String getAns2() {
	        return ans2;
	    }

	    public void setAns2(String ans2) {
	        this.ans2 = ans2;
	    }

	    public String getAns3() {
	        return ans3;
	    }

	    public void setAns3(String ans3) {
	        this.ans3 = ans3;
	    }

	    public String getAns4() {
	        return ans4;
	    }

	    public void setAns4(String ans4) {
	        this.ans4 = ans4;
	    }

	    public String getCans() {
	        return cans;
	    }

	    public void setCans(String cans) {
	        this.cans = cans;
	    }

	    public String getQno() {
	        return qno;
	    }

	    public void setQno(String qno) {
	        this.qno = qno;
	    }

	    public String getQuestion() {
	        return question;
	    }

	    public void setQuestion(String question) {
	        this.question = question;
	    }

	    public Question(String qno, String question, String ans1, String ans2, String ans3, String ans4, String cans) {
	        this.qno = qno;
	        this.question = question;
	        this.ans1 = ans1;
	        this.ans2 = ans2;
	        this.ans3 = ans3;
	        this.ans4 = ans4;
	        this.cans = cans;
	    }

	    public Question() {
	    }


	}
