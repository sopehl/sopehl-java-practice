package com.sopehl.synchronization.thread;

import java.util.Date;

import com.sopehl.synchronization.service.MessageService;

// Synchronized code blocks
public class MessageSenderThread implements Runnable{

	private MessageService messageService;
	
	private String threadName;
	
	private String messageText;
	
	private static final Integer WORKING_DURATION = 2000;
	
	public MessageSenderThread(MessageService messageService, String threadName, 
			String messageText) {
		super();
		this.messageService = messageService;
		this.threadName = threadName;
		this.messageText = messageText;
	}

	@Override
	public void run() {
		try {
			// sending the message takes times for 2 second.
			System.out.println("Try to work thread name : " + this.threadName);
			// to avoid race condition. Locked the common used object(messageText same object) reference that is passed
			// in main method.
			synchronized (messageService) {
				Thread.sleep(WORKING_DURATION);
				this.messageService.send(this.messageText + " --> associated thread with " + this.threadName);
			}
			System.out.println(this.threadName + " worked in " + String.valueOf(new Date()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
