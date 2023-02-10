package com.nt.join;

public class MyJoinMethodThread implements Runnable {
	//@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			System.out.println("Geeta Thread!");
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {

			}
		}
		}

}
