package com.nt.join.test;


public class JoinMethodTestApp02 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Geeta Thread!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

				}
			}
		});
		t.start();
		t.join(10000);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Parizaad Thread!");
		}
	}
}
