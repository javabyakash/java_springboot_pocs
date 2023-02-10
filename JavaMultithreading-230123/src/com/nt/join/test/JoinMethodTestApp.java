package com.nt.join.test;

import com.nt.join.VenueThread;
import com.nt.join.WeddingCardDistribution;
import com.nt.join.WeddingCardPrinting;

public class JoinMethodTestApp {

	public static void main(String[] args) throws Exception {
		Runnable r1 = new VenueThread();
		Runnable r2 = new WeddingCardPrinting();
		Runnable r3 = new WeddingCardDistribution();
		
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		Thread th3 = new Thread(r3);
		
		th1.start();
		th2.start();
		th3.start();
		
		th2.join();
		th3.join();
		
		for(int i=0; i<5; i++) {
			System.out.println("Main Thread");
		}
	}

}
