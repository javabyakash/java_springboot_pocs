package com.neosoft.reverse;

import java.util.Scanner;

public class NumberReverse {
	public static void main(String[] args) {
		System.out.print("Enter Your Number : ");
		int num = new Scanner(System.in).nextInt();
		int rev = 0;
		while(num!=0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		System.out.println(rev);
	}
}
