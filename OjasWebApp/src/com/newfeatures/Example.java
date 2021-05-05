package com.newfeatures;
@FunctionalInterface
interface MyInterface {
	void display();
}
public class Example {

	void myMethod() {
		System.out.println("welcome to java");
	}
	public static void main(String[] args) {
		Example obj = new Example();
		// Method reference using the object of the class
		MyInterface myref =  obj::myMethod;
		// Calling the method of functional interface  
		myref.display();

	}

}
