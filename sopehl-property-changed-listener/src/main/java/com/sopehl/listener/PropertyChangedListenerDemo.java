package com.sopehl.listener;

import com.sopehl.listener.model.User;

public class PropertyChangedListenerDemo {
	
	public static void main(String[] args) {
		User user = new User("Derek", "IT", "+905555555555");
		System.out.println(user);
		
		user.setName("John");
		System.out.println(user);
		
		user.setName("Susan");
		System.out.println(user);
	}
	
}
