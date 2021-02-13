package com.sopehl.synchronization.service;

public class SynchronizedCounterService implements Runnable{
	
	private static final Integer START_COUNTER_VALUE = 0;

	private Integer counter = SynchronizedCounterService.START_COUNTER_VALUE;
	
	private static final Integer RANGE = 10000;
	
	private Boolean isDebugMode = Boolean.FALSE;
	
	public SynchronizedCounterService() {
		super();
	}
	
	public SynchronizedCounterService(Boolean isDebugMode) {
		super();
		this.isDebugMode = isDebugMode;
	}

	@Override
	public void run() {
		for(int i = 0; i < SynchronizedCounterService.RANGE ; i++) {
			increment();
		}
	}
	
	// we lock just "this object" increment method. It works like:
	/*
	 * synchronized(this){
	 * 		return ++counter;
	 * }
	 */
	private synchronized Integer increment() {
		++counter;
		if(isDebugMode) {
			System.out.println(Thread.currentThread().getName() + " increments the value : " + counter);
		}
		return counter;
	}
	
	public Integer getCounter() {
		return this.counter;
	}
	
}
