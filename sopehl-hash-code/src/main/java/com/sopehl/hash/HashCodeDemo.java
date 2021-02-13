package com.sopehl.hash;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.sopehl.hash.model.Language;

/**
 * [reference]:
 * 
 * <p>https://www.javaworld.com/article/3305792/learn-java/java-challengers-4-comparing-java-objects-with-equals-and-hashcode.html
 * 
 * @author okan.pehlivan
 *
 */
public class HashCodeDemo {
	
	private static Integer testCounter = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// hashCode() returns the object id
		Language trLang = new Language("Turkish", Boolean.TRUE, "TR");
		Language enLang = new Language("English", Boolean.FALSE, "EN");
		
		System.out.println("========= My Execution =========");
		// 0. test
		print(trLang.equals(new Language("Turkish", Boolean.TRUE, "TR")));
		
		Language newEnLang = new Language("English", Boolean.FALSE, "EN") {
			@Override
			public int hashCode() {
				return (58 + 3434) + 1;
			}
		};
		
		// 1. test
		print(newEnLang.equals(enLang));
		
		Set<Language> langSet = new HashSet<>();
		// inserted same hashCode and different values
		langSet.add(trLang);
		
		// not inserted in the set there is a element that has the same hashCode and values
		langSet.add(new Language("Turkish", Boolean.TRUE, "TR"));
		
		// inserted same hashCode and different values
		langSet.add(enLang);
		
		// inserted because hashCode() is overridden and different hashCode
		langSet.add(newEnLang);
		
		// 2. test
		print(langSet.size());
		
		// 3. test
		print(Objects.equals(enLang, newEnLang));
		
		// generated 3 the different hashCode(overridden in String) for these strings.
		// Do not forget when you use the HashXXX classes with your classes,
		// override both the hashCode() and equals() functions. HashXXX classes control
		// object hashCode and equals functions when adding the new element.
		Set<String> nameSet = new HashSet<>();
		nameSet.add("Okan");
		nameSet.add("William");
		nameSet.add("Okan");
		nameSet.add("Brian");
		
		// 4. test
		print("nameSet size : " + nameSet.size());
		
		// identityHashCode() doesn't call the related object's hashCode() function.
		// it returns the unique id for object.
		// 5/6. test
		print(System.identityHashCode(enLang));
		print(System.identityHashCode(newEnLang));
		
		String country = "Spain";
		// 7. test
		print("hash in Class : " + country.hashCode() + " --- " + "hash from System : " + System.identityHashCode(country));
		
		// Note: to override the hashCode and equals functions,
		// the IDE code generator can be used to generate code blocks.
	}
	
	private static void print(Object o) {
		System.out.println(testCounter + ". test : " + String.valueOf(o));
		testCounter++;
	}
	
}
