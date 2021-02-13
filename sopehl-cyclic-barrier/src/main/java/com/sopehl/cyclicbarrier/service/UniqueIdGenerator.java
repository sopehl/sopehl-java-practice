package com.sopehl.cyclicbarrier.service;

import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class UniqueIdGenerator implements Runnable{

	private String name;
	
	private CyclicBarrier barrier;
	
	private static final Integer WORKING_DURATION = 2000;
	
	public UniqueIdGenerator(String name, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		String generatedValue = generate();
		System.out.println(String.format("Generated value by %s is : %s", this.name, generatedValue));
		try {
			System.out.println(String.format("%s reached the barrier", this.name));
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println("Interrupted or Broken barrier error - message : " + e.getMessage());
		}
		
		System.out.println(String.format("%s is completed :) ", this.name));
	}
	
	private String generate() {
		try {
			Thread.sleep(WORKING_DURATION);
		} catch (InterruptedException e) {
			System.out.println(String.format("Thread is interrupted named %s - message : %s", this.name, e.getMessage()));
		}
		String generatedValue = String.valueOf(UUID.randomUUID());
		return generatedValue;
	}
	
}
