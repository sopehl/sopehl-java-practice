package com.sopehl.model;

import java.io.Serializable;
import java.util.List;

public class Application implements Serializable {
	
	/**
	 * 	<p>
	 * 		If the <b>serialVersionUID</b> is changed after serialized the object with the different <b>serialVersionUID</b>. The
	 * 		below exception will be threw on console. The exception that is appeared on console is very simple.
	 * 	</p>
	 * 
	 *  <p>
	 *  	If a Serializable class doesn’t declare a serialVersionUID, the JVM will generate one automatically at run-time. 
	 *  	However, it is highly recommended that each class declares its serialVersionUID 
	 *  	<b>as the generated one is compiler dependent and thus may result in unexpected InvalidClassExceptions.</b>
	 *  </p>
	 *	 
	 *	<code>
	 *  	java.io.InvalidClassException: com.sopehl.model.Application; local class incompatible: stream classdesc serialVersionUID = 3995634962455700024, local class serialVersionUID = 3995634962455700025
	 *		at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:699)
	 *		at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1885)
	 *		at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1751)
	 *		at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2042)
	 * 		at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1573)
	 *		at java.io.ObjectInputStream.readObject(ObjectInputStream.java:431)
	 *		at com.sopehl.serialize.Serializer.deserialize(Serializer.java:47)
	 *		at com.sopehl.serializer.SerializerTest.deserializerTest_success(SerializerTest.java:32)
	 *  </code>
	 */
	private static final long serialVersionUID = 3995634962455700024L;
	//private static final long serialVersionUID = 3995634962455700025L;
	
	private String name;
	
	private String version;
	
	private List<Developer> developers;
	
	private Language language;
	
	public Application() {
		super();
	}

	public Application(String name, String version, Language language) {
		super();
		this.name = name;
		this.version = version;
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Application [name=" + name + ", version=" + version + ", developers=" + developers + ", language="
				+ language + "]";
	}
	
}
