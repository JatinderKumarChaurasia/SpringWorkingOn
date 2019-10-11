package com.jkc.aspectoriented;

public class Account {

	private int id;

	private String firstName;

	private String lastName;

	private String level;

	public Account() {
		super();
	}

	public Account(int id, String firstName, String lastName, String level) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.level = level;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLevel() {
		return level;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
