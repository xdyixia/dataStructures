package dataStructures;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		
		/*
		StackArray st1 = new StackArray();
		st1.push("abc");
		st1.push(123);
		
		int pos = st1.search("abc");
		System.out.println(pos);
		
		int a = (int)st1.pop();
		System.out.println(a);
		
		String b = (String)st1.pop();
		System.out.println(b);
*/
		
		StackLink<Integer> st2 = new StackLink<Integer>();
		System.out.println(st2.length());
		st2.push(666);
		st2.push(123);
		System.out.println(st2.length());
		Node no = st2.pop();
		int a = (int)no.e;
		System.out.println(a);
		System.out.println(st2.length());
		
	}

}
