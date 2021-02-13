package com.sopehl.hazelcast.server.instance;

import java.util.ArrayList;
import java.util.List;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastInstanceGenerator {
	
	private Boolean enableManagementCenter;
	
	public HazelcastInstanceGenerator(Boolean enableManagementCenter) {
		super();
		this.enableManagementCenter = enableManagementCenter;
	}

	public HazelcastInstance createNewInstance() {
		if(this.enableManagementCenter) {
			Config config = new Config();
			ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig("http://localhost:8080/hazelcast-mancenter", 3);
			managementCenterConfig.setEnabled(Boolean.TRUE);
			config.setManagementCenterConfig(managementCenterConfig);
			return Hazelcast.newHazelcastInstance(config);
		}
		return Hazelcast.newHazelcastInstance();
	}
	
	public List<HazelcastInstance> createNewInstances(int memberNumber) {
		List<HazelcastInstance> memberList = new ArrayList<HazelcastInstance>();
		for(int i = 0; i < memberNumber; i++) {
			memberList.add(createNewInstance());
		}
		return memberList;
	}
	
}
