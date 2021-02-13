package com.sopehl.countdownlatch.thread;

import java.util.concurrent.CountDownLatch;

public class UUIDGeneratorJob implements Runnable{
	
	private CountDownLatch downLatch;
	
	private Integer workingTime;
	
	private String name;
	
	public UUIDGeneratorJob(String name, CountDownLatch downLatch, Integer workingTime) {
		this.name = name;
		this.downLatch = downLatch;
		this.workingTime = workingTime;
	}

	public void run() {
		try {
			System.out.println("Thread working : " + this.name);
			Thread.sleep(workingTime);
			downLatch.countDown();
			System.out.println("Thread finished : " + this.name + " CounterDownLatch counter(after down) : " + downLatch.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
