package com.sopehl;

public class Test {

	public static void main(String[] args) {
		double d1 = 1.0d;
		double d2 = 0.0d;
		for (int i=0; i<10; i++) {
		  d2 += 0.1d;
		}
		System.out.println(d2 - d1);
		System.out.println(d2 == d1);
		System.out.println(d2);
		
		System.out.println(d1 == 1.0d);
	}
	
}
