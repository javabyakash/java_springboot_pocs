package com.nt.join;

public class MyJoinMethodThread03 implements Runnable {

	public static Thread mt;

	@Override
	public void run() {
		try {
			mt.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread!");
		}

	}
}
