package com.sopehl.countdownlatch;

import java.util.concurrent.CountDownLatch;

import com.sopehl.countdownlatch.thread.UUIDGeneratorJob;

public class CountDownLatchDemo {
	
	// threads will down the counter one by one, after the the counter is zero then the main thread will release through await() method.
	private static final Integer COUNTER_FOR_THREAD = 2;

	public static void main(String[] args) throws InterruptedException {
		// create the CountDownLatch with counter number
		CountDownLatch countDownLatch = new CountDownLatch(COUNTER_FOR_THREAD);
		
		// bind the created CountDownLatch with threads so that particular thread down the counter. Make sure the CountDownLatch counter and 
		// thread number is equal, otherwise the main thread won't be ended, it will control the counter is zero or not in await. At least,
		// thread number can be greater than the counter of CountDownLatch.
		UUIDGeneratorJob job1 = new UUIDGeneratorJob("JOB-1", countDownLatch, 1000);
		UUIDGeneratorJob job2 = new UUIDGeneratorJob("JOB-2", countDownLatch, 2000);
		UUIDGeneratorJob job3 = new UUIDGeneratorJob("JOB-3", countDownLatch, 5000);
		
		new Thread(job1).start();
		new Thread(job2).start();
		new Thread(job3).start();

		
		// wait for thread is above so that all of one complete the working time and control the CountDownLatch counter to be equaled to the zero.
		countDownLatch.await();
		
		
		System.out.println("End of the program[main thread]");
	}
	
}
