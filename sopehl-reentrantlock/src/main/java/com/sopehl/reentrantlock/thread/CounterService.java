package com.sopehl.reentrantlock.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized counter service one by one
 * 
 * @author okan.pehlivan
 *
 */
public class CounterService implements Runnable{

	private Integer counter = 0;
	
	private static final Integer RANGE = 100000;
	
	private Boolean isDebugMode = Boolean.FALSE;
	
	// More flexibility than Java synchronized keyword.
	// Fairness: chance of all thread to work. If we say the 100% fairness means
	// is that all of threads worked. If we say 0% fairness means that is only one 
	// thread worked. In the ReentrantLock, fairness constructor means that the next thread
	// is added to the queue when it tries to lock the resources and then the next thread
	// is selected from head of queue.
	private ReentrantLock lock = new ReentrantLock(Boolean.FALSE);
	
	private static final Integer THREAD_WORKING_DURATION = 0;
	
	private Map<String, Integer> threadWorkCount = new ConcurrentHashMap<>();

	public CounterService() {
		super();
	}
	
	public CounterService(Boolean isDebugMode) {
		super();
		this.isDebugMode = isDebugMode;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		threadWorkCount.put(threadName, 0);
		for(int i = 0; i < CounterService.RANGE; i++) {
			increment();
		}
	}
	
	/**
	 * 	ReentrantLock Methods
	 * 
		lock(): Call to the lock() method increments the hold count by 1 and gives the lock to the thread if the shared resource is initially free.
		unlock(): Call to the unlock() method decrements the hold count by 1. When this count reaches zero, the resource is released.
		tryLock(): If the resource is not held by any other thread, then call to tryLock() returns true and the hold count is incremented by one. If the resource is not free then the method returns false and the thread is not blocked but it exits.
		tryLock(long timeout, TimeUnit unit): As per the method, the thread waits for a certain time period as defined by arguments of the method to acquire the lock on the resource before exiting.
		lockInterruptibly(): This method acquires the lock if the resource is free while allowing for the thread to be interrupted by some other thread while acquiring the resource. It means that if the current thread is waiting for lock but some other thread requests the lock, then the current thread will be interrupted and return immediately without acquiring lock.
		getHoldCount(): This method returns the count of the number of locks held on the resource.
		isHeldByCurrentThread(): This method returns true if the lock on the resource is held by the current thread.
		
	 * @return counted value.
	 */
	private Integer increment() {
		String threadName = Thread.currentThread().getName();
		printLog(threadName + " waits.");
		try {
			// increase the hold count by one so lock the resource.
			lock.lock();
			printLog(threadName + " locked.");
			counter++;
			try {
				Thread.sleep(THREAD_WORKING_DURATION);
				if(threadWorkCount.containsKey(threadName)) {
					Integer workCount = threadWorkCount.get(threadName);
					workCount = workCount != null ? workCount : 0;
					workCount++;
					threadWorkCount.put(threadName, workCount);
				}
				printLog(threadName + " worked. Hold count : " + lock.getHoldCount());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}finally {
			// decrease the hold count by one.
			lock.unlock();
			printLog(threadName + " unlocked.");
		}
		
		return counter;
	}
	
	private void printLog(String logMessage) {
		if(isDebugMode) {
			System.out.println(logMessage);
		}
	}
	
	public Integer getCounter() {
		return this.counter;
	}
	
	public String getThreadWorkResult() {
		return String.valueOf(threadWorkCount);
	}
	
}
