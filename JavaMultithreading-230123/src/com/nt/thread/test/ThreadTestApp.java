package com.nt.thread.test;

import com.nt.thread.MyThread;

public class ThreadTestApp {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		Thread th = new Thread(t);
		th.start();

		System.out.println("From Main Thread!");
	}
}
