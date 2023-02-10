package com.neosoft.swapping;

public class NumberSwapping {
	public static void main(String[] args) {
		int a = 10,b=20,t;
		System.out.println("BEFORE SWAPPING A : "+a+" B : "+b);
		
		/*
		//Using 3rd variable
		t=a;
		a=b;
		b=t;
		*/
		
		/*
		//Without using 3rd variable (+ and -)
		a = a+b;
		b = a-b;
		a = a-b;
		*/
		
		/*
		//Without using 3rd variable (* and /)
		a = a*b;
		b = a/b;
		a = a/b;
		*/
		
		/*
		//Without using 3rd variable (^ X-OR operator)
		a = a^b;
		b = a^b;
		a = a^b;
		*/
		
		//In single statement
		b=a+b-(a=b);
		
		System.out.println("AFTER SWAPPING A : "+a+" B : "+b);
		
		
	}
}
