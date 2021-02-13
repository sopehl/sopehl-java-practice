package com.sopehl.synchronization;

import com.sopehl.synchronization.service.MessageService;
import com.sopehl.synchronization.thread.MessageSenderThread;

public class SynchronizationDemo {
	
	public static void main(String[] args) {
		MessageService messageService = new MessageService("SopMS");
		// pass the same messageService object to the separated thread objects and the messageService is locked in the
		// thread's jobs.
		MessageSenderThread mst1 = new MessageSenderThread(messageService, "mst1", "Hello World");
		MessageSenderThread mst2 = new MessageSenderThread(messageService, "mst2", "Thanks Alien");
		
		Thread t1 = new Thread(mst1);
		Thread t2 = new Thread(mst2);
		
		t1.start();
		t2.start();
		
		try {
			// Waits for these threads to die.
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.err.println("Thread Interrupted " + e.getMessage());
		}
		
		System.out.println("-------End of the application------");
	}
	
}
