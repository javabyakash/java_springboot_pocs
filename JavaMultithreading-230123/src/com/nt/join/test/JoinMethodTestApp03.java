package com.nt.join.test;

public class JoinMethodTestApp03 {

	public static void main(String[] args) {
		/*Runnable r = new MyJoinMethodThread03();
		Thread th = new Thread(r);
		MyJoinMethodThread03.mt = Thread.currentThread();
		th.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread!");
			try {
				th.sleep(2000);
			} catch (InterruptedException ie) {
			}
		}*/

		Thread th = new Thread(() -> {
			try {
				Thread.currentThread().join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("Child Thread!");
			}
		});
		th.start();
		for (int i = 0; i < 10; i++) {
			try {
			Thread.currentThread().sleep(2000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			System.out.println("Main Thread!");
		}
	}

}
