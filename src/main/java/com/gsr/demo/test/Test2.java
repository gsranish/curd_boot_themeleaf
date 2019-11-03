package com.gsr.demo.test;
class Parent{
	// return type is Integer
	public Integer add(Integer i,Integer j) {
		System.out.println(i*j);
		return i*j;
	}
}
public class Test2  extends Parent{
	// Overridden method but return type is void them compile time exception
	public Integer add(Integer i,Integer j) {
		Integer sum=i+j;
		System.out.println(sum);
		return sum;
	}
	public static void main(String[] args) {
		Test2 t=new Test2();
		Parent p=new Test2();
		t.add(12, 12);
		p.add(12, 5);
		new Parent().add(25, 5);
	}
}
