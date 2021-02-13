package com.sopehl.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

	public void serialize(Object o, String filename) {
		System.out.println("Object serialization has been started"); 
		
		FileOutputStream file = null;
		ObjectOutputStream out = null;
		try {
			file = new FileOutputStream(filename);
			out = new ObjectOutputStream(file); 
	        out.writeObject(o); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
				file.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
        
		System.out.println("Object serialization has been ended");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T deserialize(String filename, Class<T> clazz) {
		System.out.println("Object deserialization has been started"); 
		Object o = null;
		FileInputStream file = null;
		ObjectInputStream in = null;
        try {
        	file = new FileInputStream(filename); 
            in = new ObjectInputStream(file); 
        	
			o = in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
          
        System.out.println("Object deserialization has been ended"); 
		return (T) o;
	}
	
}
