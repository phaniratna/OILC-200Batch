package com.newfeatures;

import java.util.Arrays;

public class Example3 {

	public static void main(String[] args) {
		
		String arr[] = {"Devika","Sandya","Arun","Bhanu","Chandu"};
		Arrays.sort(arr,String::compareToIgnoreCase);
		for(String m : arr) {
			System.out.println(m);
		}

	}

}
