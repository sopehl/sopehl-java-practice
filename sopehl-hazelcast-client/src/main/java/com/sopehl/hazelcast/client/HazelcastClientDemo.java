package com.sopehl.hazelcast.client;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelcastClientDemo {
	
	private static final Boolean SIN_MODE_OPEN = Boolean.TRUE;
	
	private static final String CHANGE_MODE_KEY = "cmode";
	
	public static void main(String[] args) throws InterruptedException {
		IMap<String, String> names = null;
		try {
			HazelcastInstance hazelcastClient = HazelcastClient.newHazelcastClient();
			names = hazelcastClient.getMap("names");
			Set<Entry<String, String>> entrySet = names.entrySet();
			for(Entry<String, String> item : entrySet) {
				System.out.println(item);
			}
			
			names.put(String.valueOf(UUID.randomUUID()), "James");
		}catch (Exception e) {
			System.out.println("Run the sopehl-hazelcast-server before client is runned");
			System.out.println(e.getMessage());
		}
		
		Scanner scan = new Scanner(System.in);
		
		boolean inputMode = true;
		
		while(SIN_MODE_OPEN) {
			if(inputMode) {
				System.out.println("========== Add to IMAP =========");
				System.out.println("Enter a name: ");
				String keyboardInput= scan.nextLine();
				if(keyboardInput.equals(CHANGE_MODE_KEY)) {
					inputMode = false;
					continue;
				}
				String randomUUID = String.valueOf(UUID.randomUUID());
				names.put(randomUUID, keyboardInput);
				System.out.println("id: " + randomUUID +" - name: " + keyboardInput);
			} else {
				System.out.println("========== Get from IMAP ==========");
				System.out.println("Enter a key: ");
				String keyboardInput= scan.nextLine();
				if(keyboardInput.equals(CHANGE_MODE_KEY)) {
					inputMode = true;
					continue;
				}
				
				System.out.println("id: " + keyboardInput +" - name: " + String.valueOf(names.get(keyboardInput)));
			}
			
			Thread.sleep(1000L);
		}
		
		scan.close();
	}
	
}
