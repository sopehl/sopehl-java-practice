package com.sopehl.model;

import java.io.Serializable;

public class Developer implements Serializable{
	
	private static final long serialVersionUID = -6282527958835344461L;

	private String name;
	
	private Integer totalExperience;
	
	public Developer(String name, Integer totalExperience) {
		super();
		this.name = name;
		this.totalExperience = totalExperience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", totalExperience=" + totalExperience + "]";
	}
	
}
