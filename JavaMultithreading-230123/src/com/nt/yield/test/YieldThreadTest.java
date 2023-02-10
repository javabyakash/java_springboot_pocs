package com.nt.yield.test;

import com.nt.yield.MyThread01;
import com.nt.yield.MyThread02;

public class YieldThreadTest {

	public static void main(String[] args) throws Exception {
		Runnable r1 = new MyThread01();
		Runnable r2 = new MyThread02();
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		
		th1.start();
		th2.start();
		
		th1.setPriority(5);
		th2.setPriority(5);
		
		Thread.sleep(10000);
		
		for(int i=0;i<10;i++) {
			System.out.println("From Main Thread");
		}
	}

}
