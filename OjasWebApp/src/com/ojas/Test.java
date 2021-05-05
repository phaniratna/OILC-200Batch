package com.ojas;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class SetCopy {
	
	public static int copySets(Set<Integer> source, Set<Integer> destination) {
	if(source == null || destination == null) {
	
		return 1;
	}
	Iterator<Integer> it = source.iterator();
	while(it.hasNext()) {
			destination.add(it.next());
	}
	 return 0;
	}
}

public class Test {

   public static void main(String []args) {

	Set<Integer> s = new HashSet<Integer>();
	Set<Integer> d = new HashSet<Integer>();
	s.add(1);
	s.add(7);
	s.add(3);
	s.add(4);
	System.out.println(SetCopy.copySets(s, d));
	System.out.println(s);
   }
}
