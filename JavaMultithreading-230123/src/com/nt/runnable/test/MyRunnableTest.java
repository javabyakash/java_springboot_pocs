package com.nt.runnable.test;

import com.nt.runnable.MyRunnable;

public class MyRunnableTest {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("AKASH");
		System.out.println(Thread.currentThread().getName());
		
		Runnable r = new MyRunnable();
		Thread th = new Thread(r);
		System.out.println(th.getName());
		
		System.out.println("This line is executed by "+ Thread.currentThread().getName());
		
		th.start();
		
	}

}
