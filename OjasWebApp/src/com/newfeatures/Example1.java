package com.newfeatures;

import java.util.function.BiFunction;
class Multiplication {
	static int multiply(int a,int b) {
		return a * b;
	}
}
public class Example1 {

	public static void main(String[] args) {
		BiFunction<Integer,Integer,Integer> p = Multiplication :: multiply;
		int pr = p.apply(11, 5);  
		System.out.println("Product of given number is: "+pr);  
	}
}
