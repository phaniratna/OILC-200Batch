package com.newfeatures;
interface MyInterfaceDemo{
	void display(String mes) ;
}
class Hello{
	Hello(String mes){
		System.out.println("Welcome to " +mes);
	}
}
public class Example4 {
	public static void main(String[] args) {
		    MyInterfaceDemo obj = Hello::new;
		    obj.display("Phani");
	}
}
