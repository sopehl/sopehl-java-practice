package com.sopehl.hazelcast.server;

import java.util.UUID;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.sopehl.hazelcast.server.instance.HazelcastInstanceGenerator;

public class HazelcastServerDemo {
	
	private static final Integer NAME_COUNT = 10;
	
	public static void main(String[] args) {
		System.setProperty("hazelcast.rest.enabled", "true");
		
		HazelcastInstanceGenerator memberGenerator = new HazelcastInstanceGenerator(Boolean.TRUE);
		HazelcastInstance hazelcastInstance = memberGenerator.createNewInstance();
		
		IMap<String, String> map = hazelcastInstance.getMap("names");
		
		for(int i = 0; i < NAME_COUNT; i++) {
			String key = UUID.randomUUID().toString();
			System.out.println(key);
			map.put(key, "name" + i);
		}
	}
	
}
