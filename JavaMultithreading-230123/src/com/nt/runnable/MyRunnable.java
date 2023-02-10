package com.nt.runnable;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("This line is executed by : "+Thread.currentThread().getName());
	}

}
