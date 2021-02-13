package com.sopehl.hash.model;

public class Language {
	
	private String name;
	
	private Boolean isNative;
	
	private String code;
	
	public Language(String name, Boolean isNative, String code) {
		super();
		this.name = name;
		this.isNative = isNative;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsNative() {
		return isNative;
	}

	public void setIsNative(Boolean isNative) {
		this.isNative = isNative;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return (58 + 3434);
	}

	@Override
	public boolean equals(Object obj) {
		Language targetObject = (Language) obj;
        return this.name.equals(targetObject.name) &&
        		this.code.equals(targetObject.code) &&
        		this.isNative.equals(targetObject.isNative) &&
                this.hashCode() == targetObject.hashCode();
	}
	
}
