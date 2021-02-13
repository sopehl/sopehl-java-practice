package com.sopehl.serializer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sopehl.model.Application;
import com.sopehl.model.Developer;
import com.sopehl.model.Language;
import com.sopehl.serialize.Serializer;

public class SerializerTest {

	public Serializer serializer = new Serializer();
	
	private static final String DEFAULT_SER_FILE_NAME = "app.ser";
	
	@Test
	public void serializerTest_success() {
		Developer dev1 = new Developer("sopehl", 6);
		List<Developer> devList = Collections.singletonList(dev1);
		
		Application app = new Application("sopApp", "v1.0", Language.JAVA);
		app.setDevelopers(devList);
		
		serializer.serialize(app, DEFAULT_SER_FILE_NAME);
		
	}
	
	@Test
	public void deserializerTest_success() throws MalformedURLException, IOException {
		Application deserializedObject = serializer.deserialize(DEFAULT_SER_FILE_NAME, Application.class);
		System.out.println(deserializedObject);
		Assert.assertNotNull(deserializedObject);
	}
	
}
