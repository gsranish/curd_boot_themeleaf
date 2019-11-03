package com.gsr.demo.test;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="anish";
		String s1="anish";
		StringBuilder sb=new StringBuilder("anish");
		// sb="anish";
		System.out.println(s.hashCode());
		System.out.println(s.toCharArray());
		System.out.println(s1.hashCode());
		System.out.println(sb.hashCode());
		System.out.println(s==s1);
		System.out.println(s.equals(s1));
		System.out.println(s.equals(sb));
		System.out.println(s1.equals(sb));

	}

}
