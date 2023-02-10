package com.nt.yield;

public class MyThread01 implements Runnable {
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("From Child Thread-01");
			Thread.yield();
		}
	}
	
}
