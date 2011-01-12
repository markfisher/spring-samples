package core;

import java.util.Map;

public class Person {

	private String name;
	
	private Map<String, Object> personalInfo;

	// need default constructor
	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Map<String, Object> getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(Map<String, Object> personalInfo) {
		this.personalInfo = personalInfo;
	}

	public String toString() {
		return this.getName() + ": " + this.getPersonalInfo();
	}

}
