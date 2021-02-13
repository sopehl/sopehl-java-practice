package com.sopehl.synchronization;

import com.sopehl.synchronization.service.SynchronizedCounterService;

public class SynchronizedCounterDemo {

	public static void main(String[] args) {
		// pass the same counter services to separated thread to increase the same counter variable concurrently.
		SynchronizedCounterService counterService = new SynchronizedCounterService(Boolean.TRUE);
		
		Thread th1 = new Thread(counterService);
		Thread th2 = new Thread(counterService);
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(String.format("------End of application------{totalSum : %d}", counterService.getCounter()));
	}
	
}
