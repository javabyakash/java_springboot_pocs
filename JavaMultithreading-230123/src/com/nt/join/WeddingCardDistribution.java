package com.nt.join;

public class WeddingCardDistribution implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Wedding Card Distribution Thread");
		}
	}

}
