package com.sopehl.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.sopehl.cyclicbarrier.service.RandomGenerator;
import com.sopehl.cyclicbarrier.service.UniqueIdGenerator;

/**
 * references = ["https://www.geeksforgeeks.org/java-util-concurrent-cyclicbarrier-java/",
 * 				"https://examples.javacodegeeks.com/core-java/util/concurrent/cyclicbarrier/java-util-concurrent-cyclicbarrier-example/"];
 * @author okan.pehlivan
 *
 */
public class CyclicBarrierDemo {
	
	public static void main(String[] args) throws InterruptedException {
		// It is optional and will execute the command when barrier is tripped.
		Runnable runnable = () -> {
			System.out.println("Barrier is tripped.");
		};
		
		// CyclicBarrier is used to make threads wait for each other. CountDownLatch is not like that.
		// first parameter in constructor is the number of the thread.
		// if you don't want to execute the command after barrier tripped, just use the constructor
		// that has only one parameter-number of thread(parties)-
		CyclicBarrier barrier = new CyclicBarrier(3, runnable);
		
		// my classic service classes that is implemented by Runnable
		UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator("unique-generator", barrier);
		RandomGenerator randomGenerator = new RandomGenerator("random-generator", barrier);
		
		Thread t1 = new Thread(uniqueIdGenerator);
		Thread t2 = new Thread(randomGenerator);
		
		t1.start();
		t2.start();
		
		try {
			// main thread reach the barrier. But waits for the other thread until they reach
			// the barrier.
			System.out.println(String.format("Main thread reached the barrier"));
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println("Interrupted or Broken barrier error - message : " + e.getMessage());
		}
		
		// this output maybe not in the end of the console, because of race condition.
		// It can be synchronized by countDownLatch :)
		System.out.println("------End of application------");
		
	}
	
}
