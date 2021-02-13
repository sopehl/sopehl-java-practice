package com.sopehl.synchronization.service;

public class MessageService {

	private String messageServiceName;
	
	public MessageService(String messageServiceName) {
		super();
		this.messageServiceName = messageServiceName;
	}
	
	public String send(String message) {
		System.out.println(this.messageServiceName + " sent : " + message);
		return message;
	}
	
}
