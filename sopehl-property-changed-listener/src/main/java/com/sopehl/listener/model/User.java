package com.sopehl.listener.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class User implements PropertyChangeListener {

	private String name;

	private String department;

	private String phoneNumber;

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public User(String name, String department, String phoneNumber) {
		super();
		this.name = name;
		this.department = department;
		this.phoneNumber = phoneNumber;
		this.pcs.addPropertyChangeListener(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;

		pcs.firePropertyChange("name", oldValue, name);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Field name: " + String.valueOf(evt.getPropertyName()));
		System.out.println("Old value: " + String.valueOf(evt.getOldValue()));
		System.out.println("New value: " + String.valueOf(evt.getNewValue()));
		System.out.println("Source value: " + String.valueOf(evt.getSource()));
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", department=" + department + ", phoneNumber=" + phoneNumber + "]";
	}

}
