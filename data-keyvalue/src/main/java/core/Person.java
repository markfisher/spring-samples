package core;

import java.io.Serializable;


public class Person implements Serializable {

	private static final long serialVersionUID = -7528981484262814503L;

	private String name;
	
	private String city;

	private String state;

	// need default constructor
	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String toString() {
		return this.getName() + ": " + this.getCity() + ", " + this.getState();
	}

}
