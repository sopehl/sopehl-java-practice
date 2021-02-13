package com.sopehl.reentrantlock;

import com.sopehl.reentrantlock.thread.CounterService;

public class ReentrantLockDemo {

	public static void main(String[] args) {
		CounterService counterService = new CounterService(Boolean.TRUE);
		
		Thread t1 = new Thread(counterService, "t1");
		Thread t2 = new Thread(counterService, "t2");
		Thread t3 = new Thread(counterService, "t3");

		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(counterService.getThreadWorkResult());
		
		System.out.println("-------End of app-------");
		System.out.println("Total counter : " + counterService.getCounter());
	}
	
}
